package com.epam.bookingsystem;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    final
    UserRepository repository;

    public UserDetailsServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("MyUserDetailsService " + "loadUserByUsername(String userName) " + userName);
        Optional<User> myUser = repository.findByEmail(userName);

        myUser.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return new UserDetailsImplementation(myUser.get());
    }
}