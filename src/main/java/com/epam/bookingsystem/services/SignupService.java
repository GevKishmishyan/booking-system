package com.epam.bookingsystem.services;


import com.epam.bookingsystem.dto.request.SignupUserRequestDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.model.User;

import java.util.Optional;

public interface SignupService {

    UserResponseDTO saveUser(SignupUserRequestDTO signupUserRequestDTO);
    Optional<User> findByEmail(String email);
    MessageResponse confirmEmail(String code);
    void sendNewAccessCode(String email);
    UserResponseDTO saveModerator(String email);
}
