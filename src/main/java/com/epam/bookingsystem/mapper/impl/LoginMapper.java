package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.User;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper implements Mapper<User, LoginRequestDTO, UserResponseDTO> {

    @Override
    public User mapToEntity(LoginRequestDTO loginRequestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO mapToResponseDto(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setProfilePicture(user.getProfilePicture());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setBirthday(user.getBirthday());

        return userResponseDTO;
    }
}
