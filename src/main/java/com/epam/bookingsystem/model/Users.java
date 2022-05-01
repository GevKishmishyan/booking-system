package com.epam.bookingsystem.model;


import com.epam.bookingsystem.model.enums.Gender;
import com.epam.bookingsystem.model.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private LocalDateTime birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean enabled = false;

    private boolean notBlocked = true;

    private String profilePicture;
    @Size(min = 6)
    private String password;
    private LocalDateTime createdAt;

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

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isNotBlocked() {
        return notBlocked;
    }

    public void setNotBlocked(boolean notBlocked) {
        this.notBlocked = notBlocked;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return enabled == users.enabled &&
                notBlocked == users.notBlocked &&
                Objects.equals(firstName, users.firstName) &&
                Objects.equals(lastName, users.lastName) &&
                Objects.equals(birthday, users.birthday) &&
                gender == users.gender &&
                Objects.equals(email, users.email) &&
                role == users.role &&
                Objects.equals(profilePicture, users.profilePicture) &&
                Objects.equals(password, users.password) &&
                Objects.equals(createdAt, users.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, gender, email, role, enabled, notBlocked, profilePicture, password, createdAt);
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                ", notBlocked=" + notBlocked +
                ", profilePicture='" + profilePicture + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}