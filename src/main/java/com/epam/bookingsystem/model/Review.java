package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private long booking;
    private Double rate;
    private String comment;

    public Review(long id, long bookingId, Double rate, String comment) {
        this.id = id;
        this.booking = bookingId;
        this.rate = rate;
        this.comment = comment;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBooking() {
        return booking;
    }

    public void setBooking(long bookingId) {
        this.booking = bookingId;
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
        return Objects.equals(id, review.id) && Objects.equals(booking, review.booking) && Objects.equals(rate, review.rate) && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, booking, rate, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", bookingId=" + booking +
                ", rate=" + rate +
                ", comment='" + comment + '\'' +
                '}';
    }
}
