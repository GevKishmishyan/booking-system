
package com.epam.bookingsystem.model;

import javax.persistence.*;
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
    @Column(name = "all_pr")
    private BigDecimal allPr;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private Users users;

    public Booking() {
    }

    public Booking(long id, LocalDateTime bookedFrom,
                   LocalDateTime bookedTo, BigDecimal allPr,
                   Room room, Users users) {
        this.id = id;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.allPr = allPr;
        this.room = room;
        this.users = users;
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

    public BigDecimal getAllPr() {
        return allPr;
    }

    public void setAllPr(BigDecimal allPr) {
        this.allPr = allPr;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && Objects.equals(bookedFrom, booking.bookedFrom) && Objects.equals(bookedTo, booking.bookedTo) && Objects.equals(allPr, booking.allPr) && Objects.equals(room, booking.room) && Objects.equals(users, booking.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookedFrom, bookedTo, allPr, room, users);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookedFrom=" + bookedFrom +
                ", bookedTo=" + bookedTo +
                ", allPr=" + allPr +
                ", room=" + room +
                ", users=" + users +
                '}';
    }
}
