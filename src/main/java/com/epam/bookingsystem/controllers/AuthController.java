package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.UserDTO;
import com.epam.bookingsystem.dto.request.LoginRequestDTO;
import com.epam.bookingsystem.dto.response.LoginResponseDTO;
import com.epam.bookingsystem.dto.response.MessageResponse;
import com.epam.bookingsystem.entitys.BlockedJWTData;
import com.epam.bookingsystem.entitys.User;
import com.epam.bookingsystem.repository.BlockedJWTDataRepository;
import com.epam.bookingsystem.repository.UserRepository;
import com.epam.bookingsystem.security.CurrentUser;
import com.epam.bookingsystem.security.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.epam.bookingsystem.dto.request.LogOutRequestDTO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    BlockedJWTDataRepository blockedJWTDataRepository;

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;


    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {

        System.out.println("AuthController " + "/login " + loginRequest.toString());
        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (DisabledException e) {
            throw new RuntimeException("USER_DISABLED", e);
        } catch (BadCredentialsException exception) {
            throw new RuntimeException("Bad credentials " + loginRequest.getUsername() + " " + loginRequest.getPassword());
        } catch (AccountStatusException exception) {
            // Base class for authentication exceptions which are caused by a particular user account status (locked, disabled etc).
            throw new RuntimeException(exception);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CurrentUser userDetails = (CurrentUser) authentication.getPrincipal();
        String jwtAccess = jwtUtils.generateJwtToken(userDetails, false);
        String jwtRefresh = jwtUtils.generateJwtToken(userDetails, true);
        User user = userDetails.getUser();
        UserDTO userDTO = new UserDTO(
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.isEnabled(), user.getProfilePicture(), user.getCreatedAt()
        );

        return ResponseEntity.ok(new LoginResponseDTO(jwtAccess, jwtRefresh, userDTO));
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


    //    @PostMapping("/refreshtoken")
//    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
////        System.out.println("AuthController " + "refreshtoken");
////        String requestRefreshToken = request.getRefreshToken();
////
////        return refreshTokenService.findByToken(requestRefreshToken)
////                .map(refreshTokenService::verifyExpiration)
////                .map(RefreshToken::getUser)
////                .map(user -> {
////                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
////                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
////                })
////                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
////                        "Refresh token is not in database!"));
//        return null;
//    }
//
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequestDTO logOutRequestDTO, HttpServletRequest request) {
        System.out.println("AuthController " + "/logout ");

        String jwtAccess = parseJwt(request);

        String jwtRefresh = logOutRequestDTO.getJwtRefresh();

        boolean jwtRefreshIsValid = jwtUtils.validateJwtToken(jwtRefresh);

        boolean belongsToSameUser = jwtUtils.getUserNameFromJwtToken(jwtAccess).equals(jwtUtils.getUserNameFromJwtToken(jwtRefresh));

        boolean expirationDateDefferenceIsCorrect = false;

        System.out.println(jwtUtils.extractExpiration(jwtAccess).getTime());
        System.out.println(jwtUtils.extractExpiration(jwtRefresh).getTime());

        if (jwtUtils.extractExpiration(jwtRefresh).getTime()
                == jwtUtils.extractExpiration(jwtAccess).getTime() + 120000) {

            expirationDateDefferenceIsCorrect = true;
        }

        System.out.println(jwtRefreshIsValid);
        System.out.println(belongsToSameUser);
        System.out.println(expirationDateDefferenceIsCorrect);



        if (jwtRefreshIsValid && belongsToSameUser && expirationDateDefferenceIsCorrect) {


            BlockedJWTData blockedAccessJWTData = new BlockedJWTData(jwtAccess);
            BlockedJWTData blockedRefreshJWTData = new BlockedJWTData(jwtRefresh);

            blockedJWTDataRepository.save(blockedAccessJWTData);
            blockedJWTDataRepository.save(blockedRefreshJWTData);

            return ResponseEntity.ok(new MessageResponse("Log out successful!"));
        }
        return ResponseEntity.ok(new MessageResponse("xxxxx"));
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

}
