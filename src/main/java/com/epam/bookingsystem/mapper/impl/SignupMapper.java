package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.SignupUserRequestDTO;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SignupMapper implements Mapper<User, SignupUserRequestDTO, UserResponseDTO> {


    @Override
    public User mapToEntity(SignupUserRequestDTO requestDTO) {
        User user = new User();
        user.setEmail(requestDTO.getEmail());
        user.setLastName(requestDTO.getLastName());
        user.setFirstName(requestDTO.getFirstName());
        user.setPassword(requestDTO.getPassword());
        user.setRole(requestDTO.getRole());
        user.setCreatedAt(LocalDateTime.now());
        user.setGender(requestDTO.getGender());
        return user;
    }

    @Override
    public UserResponseDTO mapToResponseDto(User user) {
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
