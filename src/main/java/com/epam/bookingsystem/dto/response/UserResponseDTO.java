package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.enums.Gender;
import com.epam.bookingsystem.model.enums.Role;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserResponseDTO extends ResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private LocalDateTime birthday;
    private String profilePicture;
    private LocalDateTime createdAt;
    private Gender gender;

    public UserResponseDTO(Long id, String firstName, String lastName, String email, Role role,
                           LocalDateTime birthday, String profilePicture, LocalDateTime createdAt, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.birthday = birthday;
        this.profilePicture = profilePicture;
        this.createdAt = createdAt;
        this.gender = gender;
    }

    public UserResponseDTO() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponseDTO that = (UserResponseDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && role == that.role && Objects.equals(birthday, that.birthday) && Objects.equals(profilePicture, that.profilePicture) && Objects.equals(createdAt, that.createdAt) && gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, role, birthday, profilePicture, createdAt, gender);
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", birthday=" + birthday +
                ", profilePicture='" + profilePicture + '\'' +
                ", createdAt=" + createdAt +
                ", gender=" + gender +
                '}';
    }
}