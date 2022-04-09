package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private boolean isActive;
    private String profilePicture;

    private String password;
    private String confirmPassword;  // todo: check this field;

    private List<Review> reviews;
    private List<Booking> bookings;

    private LocalDateTime createdAt;

}
