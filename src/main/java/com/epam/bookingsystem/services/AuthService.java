package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ForgotPasswordRequestDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.request.PasswordResetRequest;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.TokenRefreshResponseDTO;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    LoginResponseDTO loginUser(LoginRequestDTO loginRequest);

    /**
     * Logouts the user from the system by adding it`s access jwt and refresh jwt to the redis database blacklist.
     *
     * @param request          HttpServletRequest object from witch has to be taken the access jwt token to be added to the redis database blacklist.
     * @return returns a successful logout message if the logout process was successful.
     */
    MessageResponse logoutUser(HttpServletRequest request);

    TokenRefreshResponseDTO refreshToken(HttpServletRequest httpServletRequest);

    MessageResponse resetPassword(PasswordResetRequest passwordResetRequest);
    void sendEmail(String email);
    void resetForgottenPassword(ForgotPasswordRequestDTO forgotPasswordRequestDTO);
}
