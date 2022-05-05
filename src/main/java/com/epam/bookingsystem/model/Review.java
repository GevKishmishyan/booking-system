package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review extends BaseEntity{
    private Double rate;
    private String comment;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "resort_id")
    private Resort resort;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private User users;

    public Review() {
    }

    public Review(long id, Double rate,
                  String comment,
                  Resort resort,
                  User users) {
        this.id = id;
        this.rate = rate;
        this.comment = comment;
        this.resort = resort;
        this.users = users;
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

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && Objects.equals(rate, review.rate) && Objects.equals(comment, review.comment) && Objects.equals(resort, review.resort) && Objects.equals(users, review.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rate, comment, resort, users);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rate=" + rate +
                ", comment='" + comment + '\'' +
                ", resort=" + resort +
                ", users=" + users +
                '}';
    }
}
