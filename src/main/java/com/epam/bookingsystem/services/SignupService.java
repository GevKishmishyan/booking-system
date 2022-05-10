package com.epam.bookingsystem.services;


import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.model.User;

import java.util.Optional;

public interface SignupService {

    String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
    UserResponseDTO save(User user);
    Optional<User> findByEmail(String email);
    MessageResponse confirmEmail(String code);
}
