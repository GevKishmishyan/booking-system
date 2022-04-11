package com.epam.bookingsystem;

import com.epam.bookingsystem.model.AuthenticationRequest;
import com.epam.bookingsystem.model.AuthenticationResponse;
import com.epam.bookingsystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    final
    AuthenticationManager authenticationManager;
    final
    UserDetailsServiceImplementation userDetailsService;
    final
    JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, UserDetailsServiceImplementation userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }


    // todo this mapping has to be postMapping instead
    //  of getMapping but I got problem with post mapping and have to fix it later;
    @GetMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        // todo to be removed;
        System.out.println("/authenticate " + authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());

        UsernamePasswordAuthenticationToken authenticate = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        try {
            authenticationManager.authenticate(authenticate);
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException exception) {
            throw new Exception("Bad credentials " + authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
        }

        final UserDetails userDetails = userDetailsService.
                loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome Home</h1>");
    }


    // todo this has to be removed;
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }


    // todo this has to be removed;
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
