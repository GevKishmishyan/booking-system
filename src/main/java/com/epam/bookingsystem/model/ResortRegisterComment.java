package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "resort_register_comment")
public class ResortRegisterComment extends BaseEntity {

    @NotBlank
    private String comment;

    private LocalDateTime createdAt = LocalDateTime.now();

    public ResortRegisterComment() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ResortRegisterComment{" +
                "comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
