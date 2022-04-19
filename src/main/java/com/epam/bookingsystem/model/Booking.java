
package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime bookedFrom;
    private LocalDateTime bookedTo;
    @NotNull
    @Column(name = "all_price")
    private BigDecimal price;

    public Booking(long id, LocalDateTime bookedFrom, LocalDateTime bookedTo, @NotNull BigDecimal price) {
        this.id = id;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.price = price;
    }

    public Booking() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(LocalDateTime bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public LocalDateTime getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(LocalDateTime bookedTo) {
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
        return id == booking.id && Objects.equals(bookedFrom, booking.bookedFrom) && Objects.equals(bookedTo, booking.bookedTo) && Objects.equals(price, booking.price);
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
