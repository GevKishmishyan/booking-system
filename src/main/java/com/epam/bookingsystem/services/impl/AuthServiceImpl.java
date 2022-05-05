package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dao.JWTBlacklistDAO;
import com.epam.bookingsystem.dto.request.ForgotPasswordRequestDTO;
import com.epam.bookingsystem.dto.request.LogOutRequestDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.request.PasswordResetRequest;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.TokenRefreshResponseDTO;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.exception.EntityNotFoundException;
import com.epam.bookingsystem.exception.IncorrectCurrentPasswordException;
import com.epam.bookingsystem.model.AccessCode;
import com.epam.bookingsystem.model.User;
import com.epam.bookingsystem.repository.AccessCodeRepository;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.security.CurrentUser;
import com.epam.bookingsystem.security.util.JwtUtils;
import com.epam.bookingsystem.services.AuthService;
import com.epam.bookingsystem.services.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private final AccessCodeRepository accessCodeRepository;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final JWTBlacklistDAO jwtBlacklistDAO;

    @Value("${jwt.accessExpirationMs}")
    private int jwtAccessExpirationMs;
    @Value("${jwt.refreshExpirationMs}")
    private int jwtRefreshExpirationMs;


    public AuthServiceImpl(AccessCodeRepository accessCodeRepository, MailService mailService,
                           AuthenticationManager authenticationManager, UserRepository userRepository
            , JwtUtils jwtUtils, PasswordEncoder passwordEncoder,
                           UserDetailsServiceImpl userDetailsService, JWTBlacklistDAO jwtBlacklistDAO) {
        this.accessCodeRepository = accessCodeRepository;
        this.mailService = mailService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtBlacklistDAO = jwtBlacklistDAO;
    }

    @Override
    public LoginResponseDTO loginUser(LoginRequestDTO loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        String jwtAccess = jwtUtils.generateJwtToken(currentUser, false);
        String jwtRefresh = jwtUtils.generateJwtToken(currentUser, true);

        // todo be replaced by using mapper
        User user = currentUser.getUser();
        UserResponseDTO userResponseDTO = new UserResponseDTO(
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.getProfilePicture(), user.getCreatedAt(), user.getGender()
        );
        log.info("user with userName " + loginRequest.getUsername() + " is logged in successfully");
        return new LoginResponseDTO(jwtAccess, jwtRefresh, userResponseDTO);
    }

    /**
     * Logouts the user from the system by adding it`s access jwt and refresh jwt to the redis database blacklist.
     *
     * @param logOutRequestDTO contains the refresh token has to be added in the redis database blacklist.
     * @param request          HttpServletRequest object from witch has to be taken the access jwt token to be added to the redis database blacklist.
     * @return returns a successful logout message if the logout process was successful.
     */
    @Override
    public MessageResponse logoutUser(LogOutRequestDTO logOutRequestDTO, HttpServletRequest request) {

        String jwtAccess = jwtUtils.parseJwt(request);
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
            // todo replase this with right exception
            throw new RuntimeException("JWTs dont belong to same user");
        }
        if (!expirationDateDifferenceIsCorrect) {
            log.error("jwts expiration date difference is not correct");
            // todo replase this with right exception
            throw new RuntimeException("jwts expiration date difference is not correct");
        }
        jwtBlacklistDAO.addJWTInBlacklist(jwtAccess);
        jwtBlacklistDAO.addJWTInBlacklist(jwtRefresh);
        log.info(" the user with username " + getUserDetails().getUsername() + " logged out successfully ");
        return new MessageResponse("Log out successful!");
    }

    @Override
    public TokenRefreshResponseDTO refreshToken(HttpServletRequest httpServletRequest) {
        String requestJwtRefresh = jwtUtils.parseJwt(httpServletRequest);
        CurrentUser currentUser = (CurrentUser) userDetailsService.loadUserByUsername(
                jwtUtils.getUserNameFromJwtToken(requestJwtRefresh));

        String jwtAccess = jwtUtils.generateJwtToken(currentUser, false);
        String jwtRefresh = jwtUtils.generateJwtToken(currentUser, true);
        log.info("successfully jwt refresh for the user with username "
                + getUserDetails().getUsername() + " with access token "
                + jwtAccess + " , and with refresh token " + jwtRefresh);
        return new TokenRefreshResponseDTO(jwtAccess, jwtRefresh);
    }

    @Override
    public MessageResponse resetPassword(PasswordResetRequest passwordResetRequest) {

        UserDetails userDetails = getUserDetails();
        Optional<User> optionalUser = userRepository.findByEmail(userDetails.getUsername());
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (passwordEncoder.matches(passwordResetRequest.getCurrentPassword(), user.getPassword())) {

            user.setPassword(passwordEncoder.encode(passwordResetRequest.getNewPassword()));
            userRepository.save(user);
            log.info("successful password reset by a user with a username " + getUserDetails().getUsername()
                    + ", new password is " + passwordResetRequest.getCurrentPassword());
        } else {
            log.error("user with the username " + getUserDetails().getUsername() + " provided an incorrect current password");
            throw new IncorrectCurrentPasswordException("Incorrect password");
        }
        return new MessageResponse("Password reset was successful");
    }

    private static CurrentUser getUserDetails() {
        return (CurrentUser) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    @Override
    public void sendEmail(String email) {
        String subject = "Your verification link and code";
        String code = mailService.generatePassword();
        User byEmail = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + "email does not exist"));

        if (byEmail.isEnabled() && !byEmail.isBlocked()) {
            Optional<AccessCode> byUserId = accessCodeRepository.findByUserId(byEmail.getId());
            if (byUserId.isPresent()) {
                mailService.send(email, subject, code);
                byUserId.get().setCode(code);
                byUserId.get().setCreatedDate(LocalDateTime.now());
                accessCodeRepository.save(byUserId.get());
            } else {
                mailService.send(email, subject, code);
                AccessCode accessCode = new AccessCode();
                accessCode.setCode(code);
                accessCode.setUser(byEmail);
                accessCode.setCreatedDate(LocalDateTime.now());

                accessCodeRepository.save(accessCode);
            }
        } else {
            throw new RuntimeException("Account either disabled or blocked");
        }
    }

    //todo rename method
    @Override
    public void resetForgottenPassword(ForgotPasswordRequestDTO forgotPasswordRequestDTO) {
        Optional<AccessCode> byCode = accessCodeRepository.findByCode(forgotPasswordRequestDTO.getCode());
        if (byCode.isEmpty()) {
            throw new RuntimeException("Code does not exist");
        }
        if (forgotPasswordRequestDTO.getPassword().equals(forgotPasswordRequestDTO.getConfirmPassword())) {
            Optional<User> userById = userRepository.findById(byCode.get().getUser().getId());
            userById.get().setPassword(passwordEncoder.encode(forgotPasswordRequestDTO.getPassword()));
            userRepository.save(userById.get());
            accessCodeRepository.deleteById(byCode.get().getId());
        } else {
            throw new RuntimeException("Password and confirm_password do not match");
        }

    }
}
