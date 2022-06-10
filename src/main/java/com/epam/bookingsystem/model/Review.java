package com.epam.bookingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review extends BaseEntity {
    private Double rate;
    private String comment;

    public Review(long id, Double rate, String comment) {
        super(id);
        this.rate = rate;
        this.comment = comment;
    }

    public Review() {
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
        return Objects.equals(rate, review.rate) && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "rate=" + rate +
                ", comment='" + comment + '\'' +
                '}';
    }
}
