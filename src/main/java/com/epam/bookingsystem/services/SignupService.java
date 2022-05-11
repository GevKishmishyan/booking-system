package com.epam.bookingsystem.services;


import com.epam.bookingsystem.dto.request.SignupRequestDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.model.User;

import java.util.Optional;

public interface SignupService {

    UserResponseDTO save(SignupRequestDTO signupRequestDTO);
    Optional<User> findByEmail(String email);
    MessageResponse confirmEmail(String code);
}
