package com.epam.bookingsystem.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "jwtblacklist")
public class BlockedJWTData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jWT;

    private Date createdAt;

    public BlockedJWTData(String jWT) {
        this.jWT = jWT;
        createdAt = new Date();
    }

    public BlockedJWTData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getjWT() {
        return jWT;
    }

    public void setjWT(String jWT) {
        this.jWT = jWT;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
