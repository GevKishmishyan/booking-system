//package com.epam.bookingsystem.controllers;
//
//import com.epam.bookingsystem.dto.request.SignupUserRequestDTO;
//import com.epam.bookingsystem.dto.response.MessageResponse;
//import com.epam.bookingsystem.dto.response.UserResponseDTO;
//import com.epam.bookingsystem.http.ResponseBuilder;
//import com.epam.bookingsystem.mapper.Mapper;
//import com.epam.bookingsystem.mapper.impl.SignupMapper;
//import com.epam.bookingsystem.model.User;
//import com.epam.bookingsystem.services.SignupService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Slf4j
//@RestController
//@RequestMapping("/signup")
//public class SignupController {
//
//    private final SignupService signupService;
//    private final Mapper<User, SignupUserRequestDTO, UserResponseDTO> signupMapper;
//
//
//    private final Mapper<User, SignupUserRequestDTO, UserResponseDTO> signupMapper;
//
//    public SignupController(SignupService signupService, SignupMapper signupMapper) {
//        this.signupService = signupService;
//        this.signupMapper = signupMapper;
//    }
//
//    @PostMapping("/user")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupUserRequestDTO signupUserRequestDTO, BindingResult bindingResult) {
//        Optional<User> byEmail = signupService.findByEmail(signupUserRequestDTO.getEmail());
//        if (byEmail.isPresent()) {
//            bindingResult.rejectValue(
//                    "email",
//                    "error.user",
//                    "User with this email already exists. Login or reset your password.");
//        }
//        if (bindingResult.hasErrors()) {
//            return ResponseBuilder.build(HttpStatus.BAD_REQUEST, bindingResult.getAllErrors());
//
//        }
//
//
//        User savedUser = signupService.saveUser(signupUserRequestDTO);
//
//
//        return ResponseBuilder.build(HttpStatus.OK, savedUser, signupMapper);
//
//    }
//
//    @PostMapping("/moderator")
//    public ResponseEntity<UserResponseDTO> registerModerator(@RequestParam("email") String email) {
//
//        User user = signupService.saveModerator(email);
//        return ResponseBuilder.build(HttpStatus.OK, user, signupMapper);
//    }
//
//    @GetMapping("/confirm-email/{code}")
//    public ResponseEntity<MessageResponse> confirmEmail(@PathVariable("code") String code) {
//        MessageResponse messageResponse = signupService.confirmEmail(code);
//        return ResponseBuilder.build(HttpStatus.OK, messageResponse);
//    }
//
//    @PostMapping("/send-new-access-code")
//    public ResponseEntity<?> sendNewAccessCode(@RequestParam("email") String email) {
//        signupService.sendNewAccessCode(email);
//        return ResponseBuilder.build(HttpStatus.OK);
//    }
//
//}
