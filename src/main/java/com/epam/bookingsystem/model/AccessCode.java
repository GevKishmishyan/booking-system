package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_code")
public class AccessCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @OneToOne
    @JoinColumn(name = "users_id")
    private Users user;
    private LocalDateTime createdAt;

    public AccessCode() {
    }

    public AccessCode(Long id, String code, Users user, LocalDateTime createdAt) {
        this.id = id;
        this.code = code;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdAt;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdAt = createdDate;
    }
}
