package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.UserDTO;
import com.epam.bookingsystem.dto.request.LogOutRequestDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.request.PasswordResetRequest;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.TokenRefreshResponseDTO;
import com.epam.bookingsystem.entitys.User;
import com.epam.bookingsystem.exceptions.IncorrectCurrentPasswordException;
import com.epam.bookingsystem.exceptions.JwtsExpirationDateDifferenceIsNotCorrectException;
import com.epam.bookingsystem.exceptions.UserHasToBeBlockedException;
import com.epam.bookingsystem.repository.JWTBlacklistDAO;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.security.CurrentUser;
import com.epam.bookingsystem.security.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final JWTBlacklistDAO jwtBlacklistDAO;


    private int jwtAccessExpirationMs;
    private int jwtRefreshExpirationMs;

    @Value("${jwt.accessExpirationMs}")
    public void setJwtAccessExpirationMs(int jwtAccessExpirationMs) {
        this.jwtAccessExpirationMs = jwtAccessExpirationMs;
    }

    @Value("${jwt.refreshExpirationMs}")
    public void setJwtRefreshExpirationInMs(int jwtRefreshExpirationMs) {
        this.jwtRefreshExpirationMs = jwtRefreshExpirationMs;
    }

    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository
            , JwtUtils jwtUtils, PasswordEncoder passwordEncoder,
                       UserDetailsServiceImpl userDetailsService, JWTBlacklistDAO jwtBlacklistDAO) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtBlacklistDAO = jwtBlacklistDAO;
    }


    public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {

        Authentication authentication = null;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                            loginRequest.getPassword()));

        } catch (BadCredentialsException exception) {
            log.error("user tries to logIn but credentials are not correct " + loginRequest.toString());
        } catch (DisabledException e) {
            log.error("user tries to logIn but account is disabled " + loginRequest.toString());
        } catch (LockedException exception) {
            log.error("user tries to logIn but account is blocked " + loginRequest.toString());
            throw new RuntimeException(exception);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        String jwtAccess = jwtUtils.generateJwtToken(currentUser, false);
        String jwtRefresh = jwtUtils.generateJwtToken(currentUser, true);

        // todo be replaced by using mapper
        User user = currentUser.getUser();
        UserDTO userDTO = new UserDTO(
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.isEnabled(), user.getProfilePicture(), user.getCreatedAt()
        );
        // todo have to ask , can the password be written in the logs file (if not then I have to log only the username)
        log.info("user with userName " + loginRequest.getUsername() + " is logged in successfully , "
                + " jwtAccess = " + jwtAccess + " , jwtRefresh = " + jwtRefresh);
        return new LoginResponseDTO(jwtAccess, jwtRefresh, userDTO);
    }

    /**
     * Logouts the user from the system by adding it`s access jwt and refresh jwt to the redis database blacklist.
     *
     * @param logOutRequestDTO contains the refresh token has to be added in the redis database blacklist.
     * @param request          HttpServletRequest object from witch has to be taken the access jwt token to be added to the redis database blacklist.
     * @return returns a successful logout message if the logout process was successful.
     */
    public MessageResponse logoutUser(LogOutRequestDTO logOutRequestDTO, HttpServletRequest request) {

        String jwtAccess = parseJwt(request);
        String jwtRefresh = logOutRequestDTO.getJwtRefresh();

        jwtUtils.validateJwtToken(jwtAccess);
        jwtUtils.validateJwtToken(jwtRefresh);

        boolean belongsToSameUser = jwtUtils.getUserNameFromJwtToken(jwtAccess).equals(jwtUtils.getUserNameFromJwtToken(jwtRefresh));
        boolean expirationDateDifferenceIsCorrect = false;

        if (jwtUtils.extractExpiration(jwtRefresh).getTime()
                == jwtUtils.extractExpiration(jwtAccess).getTime()
                + jwtRefreshExpirationMs - jwtAccessExpirationMs) {
            expirationDateDifferenceIsCorrect = true;
        }


        if (!belongsToSameUser) {
            log.error("jwt access and jwt refresh do not belong to the same user , "
                    + "jwt access = " + jwtAccess + "jwt refresh = " + jwtRefresh);
            throw new UserHasToBeBlockedException(jwtAccess, jwtRefresh);
        }

        if (!expirationDateDifferenceIsCorrect) {
            log.error("jwts expiration date difference is not correct");
            throw new JwtsExpirationDateDifferenceIsNotCorrectException(jwtAccess, jwtRefresh);
        }

        jwtBlacklistDAO.addJWTInBlacklist(jwtAccess);
        jwtBlacklistDAO.addJWTInBlacklist(jwtRefresh);
        log.info(" the user with username " + getUserDetails().getUsername() + " logged out successfully ");

        return new MessageResponse("Log out successful!");
    }

    public TokenRefreshResponseDTO refreshToken(HttpServletRequest httpServletRequest) {

        String requestJwtRefresh = parseJwt(httpServletRequest);

        CurrentUser currentUser = (CurrentUser) userDetailsService.loadUserByUsername(
                jwtUtils.getUserNameFromJwtToken(requestJwtRefresh));

        String jwtAccess = jwtUtils.generateJwtToken(currentUser, false);
        String jwtRefresh = jwtUtils.generateJwtToken(currentUser, true);
        log.info("successfull jwt refreshfor for the user with username "
                + getUserDetails().getUsername() + " with access token "
                + jwtAccess + " , and with refresh token " + jwtRefresh);

        return new TokenRefreshResponseDTO(jwtAccess, jwtRefresh);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

    public MessageResponse resetPassword(PasswordResetRequest passwordResetRequest) {

        UserDetails userDetails = getUserDetails();
        Optional<User> optionalUser = userRepository.findByEmail(userDetails.getUsername());
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));


        if (passwordEncoder.matches(passwordResetRequest.getCurrentPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(passwordResetRequest.getNewPassword()));
            userRepository.save(user);
            log.info("successful password reset by a user with a username " + getUserDetails().getUsername()
                    + ", new password is " + passwordResetRequest.getCurrentPassword());
        } else {
            log.error("user with the username " + getUserDetails().getUsername() + " provided an incorrect current password");
            throw new IncorrectCurrentPasswordException();
        }

        return new MessageResponse("Password reset was successful");
    }

    public static CurrentUser getUserDetails() {
        try {
            return (CurrentUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
        } catch (Exception ignored) {
            throw new RuntimeException("Access denied");
        }
    }
}
