package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "rate")
public class Rate extends BaseEntity {
    private Double rating;
    private Double totalRate;
    private Integer ratesCount;
    @OneToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    public Rate() {
    }

    public Rate(long id, Double rating, Double totalRate,
                Integer ratesCount, Resort resort) {
        this.id = id;
        this.rating = rating;
        this.totalRate = totalRate;
        this.ratesCount = ratesCount;
        this.resort = resort;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Double totalRate) {
        this.totalRate = totalRate;
    }

    public Integer getRatesCount() {
        return ratesCount;
    }

    public void setRatesCount(Integer ratesCount) {
        this.ratesCount = ratesCount;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return id == rate.id && Objects.equals(rating, rate.rating) && Objects.equals(totalRate, rate.totalRate) && Objects.equals(ratesCount, rate.ratesCount) && Objects.equals(resort, rate.resort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, totalRate, ratesCount, resort);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", rating=" + rating +
                ", totalRate=" + totalRate +
                ", ratesCount=" + ratesCount +
                ", resort=" + resort +
                '}';
    }
}
