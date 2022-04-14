package com.epam.bookingsystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @NotNull
    private Integer roomNumber;
    @OneToOne
    private ResortNumber resortNumber;
    @OneToMany
    private List<Booking> bookings;

    public Room(UUID id, Integer roomNumber, ResortNumber resortNumber, List<Booking> bookings) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.resortNumber = resortNumber;
        this.bookings = bookings;
    }

    public Room() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ResortNumber getResortNumber() {
        return resortNumber;
    }

    public void setResortNumber(ResortNumber resortNumber) {
        this.resortNumber = resortNumber;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(resortNumber, room.resortNumber) && Objects.equals(bookings, room.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, resortNumber, bookings);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", resortNumber=" + resortNumber +
                ", bookings=" + bookings +
                '}';
    }
}
