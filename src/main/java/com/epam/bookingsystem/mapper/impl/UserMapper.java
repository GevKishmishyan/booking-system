package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.SignupRequestDTO;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.model.User;

import java.time.LocalDateTime;

public class UserMapper {

    private UserMapper() {
        throw new IllegalStateException("Can not create an object of utility class.");
    }

    public static User dtoToUser(SignupRequestDTO request) {
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


    public static UserResponseDTO userToDto(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setProfilePicture(user.getProfilePicture());
        response.setCreatedAt(user.getCreatedAt());
        response.setGender(user.getGender());

        return response;
    }

}
