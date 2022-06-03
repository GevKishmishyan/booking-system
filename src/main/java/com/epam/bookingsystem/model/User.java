package com.epam.bookingsystem.model;


import com.epam.bookingsystem.model.enums.Gender;
import com.epam.bookingsystem.model.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

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
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean enabled = false;

    private boolean blocked = false;

    private String profilePicture = "C:\\BookingSystem\\pictures\\userDefaultProfilePicture.png";
    @OneToMany
    @JoinColumn(name = "users_id")
    private List<Booking> booking;
    @OneToMany
    @JoinColumn(name = "users_id")
    private List<Review> review;
    @NotNull
    private String password;
    private LocalDateTime createdAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_code_id",referencedColumnName = "id")
    private AccessCode accessCode;

    public User(long id, String firstName, String lastName, LocalDateTime birthday,
                Gender gender,  String email,Role role, boolean enabled,
                boolean blocked, String profilePicture, List<Booking> booking, List<Review> review,
                String password, LocalDateTime createdAt, AccessCode accessCode) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
        this.blocked = blocked;
        this.profilePicture = profilePicture;
        this.booking = booking;
        this.review = review;
        this.password = password;
        this.createdAt = createdAt;
        this.accessCode = accessCode;
    }

    public User() {
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

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
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

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled && blocked == user.blocked && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(birthday, user.birthday) && gender == user.gender && Objects.equals(email, user.email) && role == user.role && Objects.equals(profilePicture, user.profilePicture) && Objects.equals(booking, user.booking) && Objects.equals(review, user.review) && Objects.equals(password, user.password) && Objects.equals(createdAt, user.createdAt) && Objects.equals(accessCode, user.accessCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, gender, email, role, enabled, blocked, profilePicture, booking, review, password, createdAt, accessCode);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                ", blocked=" + blocked +
                ", profilePicture='" + profilePicture + '\'' +
                ", booking=" + booking +
                ", review=" + review +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", accessCode=" + accessCode +
                '}';
    }
}