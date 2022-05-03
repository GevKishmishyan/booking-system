package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.SignupRequestDTO;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.mapper.impl.UserMapper;
import com.epam.bookingsystem.model.Users;
import com.epam.bookingsystem.repository.AccessCodeRepository;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/signup")
public class SignupController {


    private final SignupService signupService;



    public SignupController( SignupService signupService) {

        this.signupService = signupService;

    }

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO signupRequestDTO, BindingResult bindingResult) {
        Optional<Users> byEmail = signupService.findByEmail(signupRequestDTO.getEmail());
        if (byEmail.isPresent()) {
            bindingResult.rejectValue(
                    "email",
                    "error.user",
                    "User with this email already exists. Login or reset your password.");
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        UserResponseDTO saveUser = signupService.save(UserMapper.dtoToUser(signupRequestDTO));
        return ResponseEntity.ok().body(saveUser);

    }

    @GetMapping("/confirm-email/{code}")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity<?> confirmEmail(@PathVariable("code") String code) {
        signupService.confirmEmail(code);


        return ResponseEntity.ok().build();
    }


}
