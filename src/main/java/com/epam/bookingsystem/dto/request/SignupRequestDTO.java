package com.epam.bookingsystem.dto.request;


import com.epam.bookingsystem.anotations.UserOrHotelManager;
import com.epam.bookingsystem.model.enums.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignupRequestDTO {


    @Size(min = 2, max = 50)
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @Size(min = 2, max = 50)
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    @UserOrHotelManager
    private Role role;

    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 24)
    @NotEmpty(message = "*Please provide your password")
    private String password;

    public SignupRequestDTO() {
    }

    public SignupRequestDTO(String firstName, String lastName, Role role, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{"
                + ", firstName='"
                + firstName
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                + ", role="
                + role
                + ", email='"
                + email
                + '\''
                + ", password='"
                + password
                + '\''
                + '}';
    }
}
