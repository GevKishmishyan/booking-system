
package com.epam.bookingsystem.model;

import javax.persistence.Column;
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
    private BigDecimal total_amount;

    public Booking(long id, LocalDateTime bookedFrom, LocalDateTime bookedTo, BigDecimal total_amount) {
        super(id);
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.total_amount = total_amount;
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
        return total_amount;
    }

    public void setTotalAmount(BigDecimal allPr) {
        this.total_amount = allPr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookedFrom, booking.bookedFrom) && Objects.equals(bookedTo, booking.bookedTo) && Objects.equals(total_amount, booking.total_amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookedFrom, bookedTo, total_amount);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookedFrom=" + bookedFrom +
                ", bookedTo=" + bookedTo +
                ", allPr=" + total_amount +
                '}';
    }
}
