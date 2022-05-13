package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.SignupUserRequestDTO;
import com.epam.bookingsystem.model.User;

import java.time.LocalDateTime;

public class SignupRequestDTOToUserMapper {

    public static User signupRequestDTOToUser(SignupUserRequestDTO request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setCreatedAt(LocalDateTime.now());
        user.setGender(request.getGender());

        return user;
    }




}
