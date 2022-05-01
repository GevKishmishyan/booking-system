package com.epam.bookingsystem;

import com.epam.bookingsystem.model.Users;
import com.epam.bookingsystem.model.enums.Role;
import com.epam.bookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

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

        Users admin = new Users();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@gmail.com");
        admin.setRole(Role.ADMIN);
        admin.setEnabled(true);
        admin.setNotBlocked(true);
        admin.setPassword(passwordEncoder.encode("12345"));
        admin.setCreatedAt(LocalDateTime.now());

        if (!userRepository.existsByEmail(admin.getEmail())) {
            userRepository.save(admin);
        }


        Users moderator = new Users();
        moderator.setFirstName("moderator");
        moderator.setLastName("moderator");
        moderator.setEmail("moderator@gmail.com");
        moderator.setRole(Role.MODERATOR);
        moderator.setEnabled(true);
        moderator.setNotBlocked(true);
        moderator.setPassword(passwordEncoder.encode("12345"));
        moderator.setCreatedAt(LocalDateTime.now());

        if (!userRepository.existsByEmail(moderator.getEmail())) {
            userRepository.save(moderator);
        }

    }
}

