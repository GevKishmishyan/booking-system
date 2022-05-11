package com.epam.bookingsystem.dto.request;


import com.epam.bookingsystem.validation.annotation.UserOrHotelManager;
import com.epam.bookingsystem.validation.annotation.ValidPassword;
import com.epam.bookingsystem.model.enums.Gender;
import com.epam.bookingsystem.model.enums.Role;

import javax.validation.constraints.*;

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

    @ValidPassword
    private String password;
    @ValidPassword
    private String confirmPassword;

    @NotNull
    private Gender gender;

    public SignupRequestDTO() {
    }

    public SignupRequestDTO(String firstName, String lastName, Role role, String email, String password, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
        return "SignupRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", gender=" + gender +
                '}';
    }
}
