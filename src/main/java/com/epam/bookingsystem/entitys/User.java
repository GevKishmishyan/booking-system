package com.epam.bookingsystem.entitys;

import com.epam.bookingsystem.entitys.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private LocalDateTime createdAt;
    // @NotBlank
    // @Size(min = 6, max = 24)
    private String password;
    @Enumerated(value = EnumType.STRING)
    public Role role;

    private boolean enabled = false;
    private boolean notBlocked = true;

    public User() {
    }

    public User( String email, String firstName, String lastName, String profilePicture, LocalDateTime createdAt, String password, Role role, boolean enabled, boolean notBlocked) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.createdAt = createdAt;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.notBlocked = notBlocked;
    }

    //
    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                notBlocked == user.notBlocked &&
                Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(profilePicture, user.profilePicture) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, profilePicture, createdAt, password, role, enabled, notBlocked);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", createdAt=" + createdAt +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                ", notBlocked=" + notBlocked +
                '}';
    }

    public boolean isNotBlocked() {
        return notBlocked;
    }

    public void setNotBlocked(boolean notBlocked) {
        this.notBlocked = notBlocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


}
