package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.SignupUserRequestDTO;
import com.epam.bookingsystem.dto.response.UserResponseDTO;
import com.epam.bookingsystem.model.User;
import com.epam.bookingsystem.services.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/signup")
public class SignupController {

    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupUserRequestDTO signupUserRequestDTO, BindingResult bindingResult) {
        Optional<User> byEmail = signupService.findByEmail(signupUserRequestDTO.getEmail());
        if (byEmail.isPresent()) {
            bindingResult.rejectValue(
                    "email",
                    "error.user",
                    "User with this email already exists. Login or reset your password.");
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        UserResponseDTO savedUser = signupService.saveUser(signupUserRequestDTO);
        return ResponseEntity.ok().body(savedUser);
    }
    @PostMapping("/moderator")
    public ResponseEntity<?> registerModerator(@RequestParam("email")String email){

        UserResponseDTO save = signupService.saveModerator(email);
        return ResponseEntity.ok().body(save);
    }

    @GetMapping("/confirm-email/{code}")
    public ResponseEntity<?> confirmEmail(@PathVariable("code") String code) {
        signupService.confirmEmail(code);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/send-new-access-code")
    public ResponseEntity<?> sendNewAccessCode(@RequestParam("email") String email) {
        signupService.sendNewAccessCode(email);
        return ResponseEntity.ok().build();
    }

}
