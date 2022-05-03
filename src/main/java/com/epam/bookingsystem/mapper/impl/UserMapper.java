package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.SignupRequestDTO;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Users;

import java.time.LocalDateTime;

public class UserMapper {

  private UserMapper() {
    throw new IllegalStateException("Can not create an object of utility class.");
  }

  public static Users dtoToUser(SignupRequestDTO request) {
    Users user = new Users();
    user.setEmail(request.getEmail());
    user.setLastName(request.getLastName());
    user.setFirstName(request.getFirstName());
    user.setPassword(request.getPassword());
    user.setRole(request.getRole());
    user.setCreatedAt(LocalDateTime.now());

    return user;
  }



  public static UserResponseDTO userToDto(Users user) {
    UserResponseDTO response = new UserResponseDTO();
    response.setFirstName(user.getFirstName());
    response.setLastName(user.getLastName());
    response.setEmail(user.getEmail());
    response.setRole(user.getRole());

    return response;
  }

}
