
package com.epam.bookingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {
    private LocalDateTime bookedFrom;
    private LocalDateTime bookedTo;
    @NotNull
    private BigDecimal totalAmount;

    public Booking(long id, LocalDateTime bookedFrom, LocalDateTime bookedTo, BigDecimal totalAmount) {
        super(id);
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.totalAmount = totalAmount;
    }

    public Booking() {
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal allPr) {
        this.totalAmount = allPr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookedFrom, booking.bookedFrom) && Objects.equals(bookedTo, booking.bookedTo) && Objects.equals(totalAmount, booking.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookedFrom, bookedTo, totalAmount);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookedFrom=" + bookedFrom +
                ", bookedTo=" + bookedTo +
                ", allPr=" + totalAmount +
                '}';
    }
}
