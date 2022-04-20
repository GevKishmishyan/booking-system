package com.epam.bookingsystem;

import com.epam.bookingsystem.entitys.User;
import com.epam.bookingsystem.entitys.enums.Role;
import com.epam.bookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BookingSystemApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BookingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setNotBlocked(true);
        user.setEnabled(true);
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("12345"));
        user.setRole(Role.ADMIN);
        if (!userRepository.existsByEmail(user.getEmail())) {
            userRepository.save(user);
        }

    }

}

