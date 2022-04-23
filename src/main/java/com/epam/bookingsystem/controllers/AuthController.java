package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.PasswordResetRequest;
import com.epam.bookingsystem.dto.response.PasswordResetResponse;
import com.epam.bookingsystem.dto.response.TokenRefreshResponseDTO;
import com.epam.bookingsystem.dto.request.LogOutRequestDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        System.out.println("AuthController " + "/login " + loginRequest.toString());
        LoginResponseDTO loginResponseDTO = authService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponseDTO);
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO signupRequestDTO) {
//
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//        }
//        ERole eRole = ERole.valueOf(signUpRequest.getRole());
//        if (eRole == null) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: no such role!"));
//        }
//
//        // Create new myUser's account
//        MyUser myUser = new MyUser(signUpRequest.getUsername(), signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword()), signUpRequest.getRole());
//        System.out.println("AuthController " + "/signup " + "created new myUser " + myUser.toString());
//
//        // Set<String> strRoles = signUpRequest.getRole();
//        // Set<Role> roles = new HashSet<>();
//
////        if (strRoles == null) {
////            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
////                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
////            roles.add(userRole);
////        } else {
////            strRoles.forEach(role -> {
////                switch (role) {
////                    case "admin":
////                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
////                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
////                        roles.add(adminRole);
////
////                        break;
////                    case "mod":
////                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
////                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
////                        roles.add(modRole);
////
////                        break;
////                    default:
////                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
////                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
////                        roles.add(userRole);
////                }
////            });
////        }
//        // myUser.setRoles(roles);
//
//
//        myUserRepository.save(myUser);
//
//        return ResponseEntity.ok(new MessageResponse("MyUser registered successfully!"));
//    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(HttpServletRequest httpServletRequest) {
        System.out.println("AuthController " + "/refreshtoken");
        TokenRefreshResponseDTO tokenRefreshResponseDTO = authService.refreshtoken(httpServletRequest);

        return ResponseEntity.ok(tokenRefreshResponseDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequestDTO logOutRequestDTO, HttpServletRequest request) {
        System.out.println("AuthController " + "/logout ");
        MessageResponse messageResponse = authService.logoutUser(logOutRequestDTO, request);
        return ResponseEntity.ok(messageResponse);
    }


    @PostMapping("/reset-password")
    public ResponseEntity<PasswordResetResponse> resetPassword(@Valid @RequestBody PasswordResetRequest passwordResetRequest) {
        System.out.println("/reset-password");
        PasswordResetResponse passwordResetResponse = authService.resetPassword(passwordResetRequest);

        return ResponseEntity.ok().body(passwordResetResponse);
    }


}
