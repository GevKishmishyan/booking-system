package com.epam.bookingsystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "room")
public class Room extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private Integer roomNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resort_id")
    private Resort resort;

    public Room() {
    }

    public Room(long id, Integer roomNumber, Resort resort) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.resort = resort;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
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
        Room room = (Room) o;
        return id == room.id && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(resort, room.resort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, resort);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", resort=" + resort +
                '}';
    }
}
