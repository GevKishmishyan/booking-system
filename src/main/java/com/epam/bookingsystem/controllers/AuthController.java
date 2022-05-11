package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.ForgotPasswordRequestDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.request.PasswordResetRequest;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.TokenRefreshResponseDTO;
import com.epam.bookingsystem.exception.dto.ErrorDetails;
import com.epam.bookingsystem.services.AuthService;
import com.epam.bookingsystem.services.impl.AuthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO loginResponseDTO = authService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponseDTO);
    }

    @ExceptionHandler()
    protected ResponseEntity<ErrorDetails> handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest request) {
        log.error("MethodArgumentNotValidException handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                exception.getMessage(), request.getDescription(false), 400);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    /**
     * Logouts the user from the system by adding it`s access jwt and refresh jwt to the redis database blacklist.
     *
     * @param request HttpServletRequest object from witch has to be taken the access jwt token to be added to the redis database blacklist.
     * @return returns a successful logout message if the logout process was successful.
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpServletRequest request) {
        MessageResponse messageResponse = authService.logoutUser(request);
        return ResponseEntity.ok(messageResponse);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest httpServletRequest) {
        TokenRefreshResponseDTO tokenRefreshResponseDTO = authService.refreshToken(httpServletRequest);
        return ResponseEntity.ok(tokenRefreshResponseDTO);
    }


    @PostMapping("/reset-password")
    public ResponseEntity<MessageResponse> resetPassword(@Valid @RequestBody PasswordResetRequest passwordResetRequest) {
        MessageResponse messageResponse = authService.resetPassword(passwordResetRequest);
        return ResponseEntity.ok().body(messageResponse);
    }

    @PostMapping("/send-mail")
    public ResponseEntity<?> sendMain(@RequestParam("email") String email) {
        authService.sendEmail(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/forgot_password")
    public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequestDTO forgotPasswordDTO) {
        authService.forgotPassword(forgotPasswordDTO);
        return ResponseEntity.ok().build();
    }

}
