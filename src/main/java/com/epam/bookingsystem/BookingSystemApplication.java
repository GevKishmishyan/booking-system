package com.epam.bookingsystem;

import com.epam.bookingsystem.model.User;
import com.epam.bookingsystem.model.enums.Gender;
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
        if (!userRepository.existsByEmail("admin@gmail.com")) {
            User admin = new User();
            admin.setCountry("Georgia");
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setEmail("admin@gmail.com");
            admin.setRole(Role.ADMIN);
            admin.setEnabled(true);
            admin.setPassword(passwordEncoder.encode("1234567"));
            admin.setCreatedAt(LocalDateTime.now());
            admin.setGender(Gender.FEMALE);
            userRepository.save(admin);
        }

        if (!userRepository.existsByEmail("moderator@gmail.com")) {
            User moderator = new User();
            moderator.setCountry("Armenia");
            moderator.setFirstName("moderator");
            moderator.setLastName("moderator");
            moderator.setEmail("moderator@gmail.com");
            moderator.setRole(Role.MODERATOR);
            moderator.setEnabled(true);
            moderator.setPassword(passwordEncoder.encode("1234567"));
            moderator.setCreatedAt(LocalDateTime.now());
            moderator.setGender(Gender.FEMALE);
            userRepository.save(moderator);
        }
    }
}

