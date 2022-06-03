package com.epam.bookingsystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "room")
public class Room extends BaseEntity {
    @NotNull
    private Integer roomNumber;
    @OneToMany
    @JoinColumn(name = "room_id")
    private List<Booking> booking;


    public Room(long id, Integer roomNumber, List<Booking> booking) {
        super(id);
        this.roomNumber = roomNumber;
        this.booking = booking;
    }

    public Room() {
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber) && Objects.equals(booking, room.booking) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, booking);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", booking=" + booking +
                '}';
    }
}
