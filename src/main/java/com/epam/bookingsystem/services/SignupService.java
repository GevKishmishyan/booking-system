//package com.epam.bookingsystem.services;
//
//
//import com.epam.bookingsystem.dto.request.SignupUserRequestDTO;
//import com.epam.bookingsystem.dto.response.MessageResponse;
//import com.epam.bookingsystem.model.User;
//
//import java.util.Optional;
//
//public interface SignupService {
//
//    User saveUser(SignupUserRequestDTO signupUserRequestDTO);
//
//    Optional<User> findByEmail(String email);
//
//    MessageResponse confirmEmail(String code);
//
//    void sendNewAccessCode(String email);
//
//    User saveModerator(String email);
//}
