package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.LogOutRequestDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.request.PasswordResetRequest;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.TokenRefreshResponseDTO;
import com.epam.bookingsystem.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO loginResponseDTO = authService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponseDTO);
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshToken(HttpServletRequest httpServletRequest) {
        TokenRefreshResponseDTO tokenRefreshResponseDTO = authService.refreshToken(httpServletRequest);
        return ResponseEntity.ok(tokenRefreshResponseDTO);
    }

    /**
     * Logouts the user from the system by adding it`s access jwt and refresh jwt to the redis database blacklist.
     *
     * @param logOutRequestDTO contains the refresh token has to be added in the redis database blacklist.
     * @param request          HttpServletRequest object from witch has to be taken the access jwt token to be added to the redis database blacklist.
     * @return returns a successful logout message if the logout process was successful.
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequestDTO logOutRequestDTO, HttpServletRequest request) {
        MessageResponse messageResponse = authService.logoutUser(logOutRequestDTO, request);
        return ResponseEntity.ok(messageResponse);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<MessageResponse> resetPassword(@Valid @RequestBody PasswordResetRequest passwordResetRequest) {
        MessageResponse messageResponse = authService.resetPassword(passwordResetRequest);
        return ResponseEntity.ok().body(messageResponse);
    }


}
