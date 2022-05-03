package com.epam.bookingsystem.services;


import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.model.Users;

import java.util.Optional;

public interface SignupService {
    String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";

    UserResponseDTO save(Users user);

    Optional<Users> findByEmail(String email);

    void confirmEmail(String code);


}
