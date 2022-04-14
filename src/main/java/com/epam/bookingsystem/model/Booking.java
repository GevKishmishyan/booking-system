package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private LocalDate bookedFrom;
    private LocalDate bookedTo;
    @NotNull
    private BigDecimal price;

    public Booking(UUID id, LocalDate bookedFrom, LocalDate bookedTo, BigDecimal price) {
        this.id = id;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.price = price;
    }

    public Booking() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(LocalDate bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public LocalDate getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(LocalDate bookedTo) {
        this.bookedTo = bookedTo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(bookedFrom, booking.bookedFrom) && Objects.equals(bookedTo, booking.bookedTo) && Objects.equals(price, booking.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookedFrom, bookedTo, price);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookedFrom=" + bookedFrom +
                ", bookedTo=" + bookedTo +
                ", price=" + price +
                '}';
    }
}
