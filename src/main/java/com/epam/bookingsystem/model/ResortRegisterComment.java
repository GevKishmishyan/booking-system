package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "resort_register_comment")
public class ResortRegisterComment extends BaseEntity {

    @NotBlank
    private String comment;

    private LocalDateTime createdAt = LocalDateTime.now();

    public ResortRegisterComment(String comment) {
        this.comment = comment;
    }

    public ResortRegisterComment() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ResortRegisterComment{" +
                "comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
