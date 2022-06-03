package com.epam.bookingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "rate")
public class Rate extends BaseEntity {
    private Double rating;
    private Double totalRate;
    private Integer ratesCount;

    public Rate(long id, Double rating, Double totalRate, Integer ratesCount) {
        super(id);
        this.rating = rating;
        this.totalRate = totalRate;
        this.ratesCount = ratesCount;
    }

    public Rate() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Objects.equals(rating, rate.rating) && Objects.equals(totalRate, rate.totalRate) && Objects.equals(ratesCount, rate.ratesCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, totalRate, ratesCount);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rating=" + rating +
                ", totalRate=" + totalRate +
                ", ratesCount=" + ratesCount +
                '}';
    }
}
