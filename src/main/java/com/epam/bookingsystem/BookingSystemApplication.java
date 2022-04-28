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

        User admin = new User();
        admin.setNotBlocked(true);
        admin.setEnabled(true);
        admin.setEmail("admin@gmail.com");
        admin.setPassword(passwordEncoder.encode("12345"));
        admin.setRole(Role.ADMIN);
        if (!userRepository.existsByEmail(admin.getEmail())) {
            userRepository.save(admin);
        }

        User moderator = new User();
        moderator.setNotBlocked(true);
        moderator.setEnabled(true);
        moderator.setEmail("moderator@gmail.com");
        moderator.setPassword(passwordEncoder.encode("12345"));
        moderator.setRole(Role.MODERATOR);
        if (!userRepository.existsByEmail(moderator.getEmail())) {
            userRepository.save(moderator);
        }

    }

}

