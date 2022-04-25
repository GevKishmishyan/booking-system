package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.UserDTO;
import com.epam.bookingsystem.dto.request.LogOutRequestDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.request.PasswordResetRequest;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.PasswordResetResponse;
import com.epam.bookingsystem.dto.response.TokenRefreshResponseDTO;
import com.epam.bookingsystem.entitys.User;
import com.epam.bookingsystem.repository.BlockedJWTDataRepository;
import com.epam.bookingsystem.repository.JWTBlacklistDAO;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.security.CurrentUser;
import com.epam.bookingsystem.security.util.JwtUtils;
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

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final BlockedJWTDataRepository blockedJWTDataRepository;
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
            , JwtUtils jwtUtils, PasswordEncoder passwordEncoder, BlockedJWTDataRepository blockedJWTDataRepository,
                       UserDetailsServiceImpl userDetailsService, JWTBlacklistDAO jwtBlacklistDAO) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.blockedJWTDataRepository = blockedJWTDataRepository;
        this.userDetailsService = userDetailsService;
        this.jwtBlacklistDAO = jwtBlacklistDAO;
    }


    public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {

        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (DisabledException e) {
            throw new RuntimeException("USER_DISABLED", e);
        } catch (BadCredentialsException exception) {
            throw new RuntimeException("Bad credentials " + loginRequest.getUsername() + " " + loginRequest.getPassword());
        } catch (AccountStatusException exception) {
            throw new RuntimeException(exception);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CurrentUser userDetails = (CurrentUser) authentication.getPrincipal();
        String jwtAccess = jwtUtils.generateJwtToken(userDetails, false);
        String jwtRefresh = jwtUtils.generateJwtToken(userDetails, true);
        User user = userDetails.getUser();
        UserDTO userDTO = new UserDTO(
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.isEnabled(), user.getProfilePicture(), user.getCreatedAt()
        );

        return new LoginResponseDTO(jwtAccess, jwtRefresh, userDTO);
    }

    public MessageResponse logoutUser(LogOutRequestDTO logOutRequestDTO, HttpServletRequest request) {
        System.out.println("authService logoutUser ");
        String jwtAccess = parseJwt(request);
        String jwtRefresh = logOutRequestDTO.getJwtRefresh();

        boolean jwtAccessIsValid = jwtUtils.validateJwtToken(jwtAccess);
        boolean jwtRefreshIsValid = jwtUtils.validateJwtToken(jwtRefresh);
        boolean belongsToSameUser = jwtUtils.getUserNameFromJwtToken(jwtAccess).equals(jwtUtils.getUserNameFromJwtToken(jwtRefresh));
        boolean expirationDateDifferenceIsCorrect = false;

        if (jwtUtils.extractExpiration(jwtRefresh).getTime()
                == jwtUtils.extractExpiration(jwtAccess).getTime()
                + jwtRefreshExpirationMs - jwtAccessExpirationMs) {
            expirationDateDifferenceIsCorrect = true;
        }

        if (jwtAccessIsValid && jwtRefreshIsValid && belongsToSameUser && expirationDateDifferenceIsCorrect) {
            System.out.println("doFilterInternal , block if ,, now  jwt has to be added in blacklist");
            //BlockedJWTData blockedAccessJWTData = new BlockedJWTData(jwtAccess);
            //BlockedJWTData blockedRefreshJWTData = new BlockedJWTData(jwtRefresh);

            // blockedJWTDataRepository.save(blockedAccessJWTData);
            // blockedJWTDataRepository.save(blockedRefreshJWTData);
            jwtBlacklistDAO.addJWTInBlacklist(jwtAccess);
            jwtBlacklistDAO.addJWTInBlacklist(jwtRefresh);

            return new MessageResponse("Log out successful!");
        }
        return null;
    }

    public TokenRefreshResponseDTO refreshToken(HttpServletRequest httpServletRequest) {

        String requestJwtRefresh = parseJwt(httpServletRequest);

        CurrentUser currentUser = (CurrentUser) userDetailsService.loadUserByUsername(
                jwtUtils.getUserNameFromJwtToken(requestJwtRefresh));

        String jwtAccess = jwtUtils.generateJwtToken(currentUser, false);
        String jwtRefresh = jwtUtils.generateJwtToken(currentUser, true);

        return new TokenRefreshResponseDTO(jwtAccess, jwtRefresh);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

    public PasswordResetResponse resetPassword(PasswordResetRequest passwordResetRequest) {

        UserDetails userDetails = getUserDetails();
        Optional<User> optionalUser = userRepository.findByEmail(userDetails.getUsername());
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(passwordResetRequest.getCurrentPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(passwordResetRequest.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new RuntimeException("incorrect current password");
        }

        String jwtAccess = jwtUtils.generateJwtToken(userDetails, false);
        String jwtRefresh = jwtUtils.generateJwtToken(userDetails, true);

        return new PasswordResetResponse(jwtAccess, jwtRefresh);
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
