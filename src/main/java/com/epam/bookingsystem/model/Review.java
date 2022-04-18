package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private UUID bookingId;
    private Double rate;
    private String comment;

    public Review(UUID id, UUID bookingId, Double rate, String comment) {
        this.id = id;
        this.bookingId = bookingId;
        this.rate = rate;
        this.comment = comment;
    }

    public Review() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(bookingId, review.bookingId) && Objects.equals(rate, review.rate) && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingId, rate, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", rate=" + rate +
                ", comment='" + comment + '\'' +
                '}';
    }
}
