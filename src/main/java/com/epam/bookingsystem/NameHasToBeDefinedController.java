package com.epam.bookingsystem;


import com.epam.bookingsystem.model.AuthenticationRequest;
import com.epam.bookingsystem.model.AuthenticationResponse;
import com.epam.bookingsystem.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameHasToBeDefinedController {

    final
    AuthenticationManager authenticationManager;
    final
    UserDetailsServiceImplementation userDetailsService;
    final
    JwtUtil jwtUtil;

    public NameHasToBeDefinedController(AuthenticationManager authenticationManager, UserDetailsServiceImplementation userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }


    // todo this mapping has to be postMapping instead
    //  of getMapping but I got problem with post mapping and have to fix it later;
    @GetMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        // todo to be removed;
        System.out.println("/authenticate");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername()
                            , authenticationRequest.getPassword()));
        } catch (BadCredentialsException exception) {
            throw new Exception("bad credentials " + authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
        }

        final UserDetails userDetails = userDetailsService.
                loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
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
