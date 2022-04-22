package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "resort_number")
public class ResortNumber extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @NotNull
    private Integer availableCount;
    @NotNull
    private BigDecimal perNightPrice;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public ResortNumber() {
    }

    public ResortNumber(long id, RoomType roomType,
                        Integer availableCount,
                        BigDecimal perNightPrice,
                        Room room) {
        this.id = id;
        this.roomType = roomType;
        this.availableCount = availableCount;
        this.perNightPrice = perNightPrice;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public BigDecimal getPerNightPrice() {
        return perNightPrice;
    }

    public void setPerNightPrice(BigDecimal perNightPrice) {
        this.perNightPrice = perNightPrice;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResortNumber that = (ResortNumber) o;
        return id == that.id && roomType == that.roomType && Objects.equals(availableCount, that.availableCount) && Objects.equals(perNightPrice, that.perNightPrice) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomType, availableCount, perNightPrice, room);
    }

    @Override
    public String toString() {
        return "ResortNumber{" +
                "id=" + id +
                ", roomType=" + roomType +
                ", availableCount=" + availableCount +
                ", perNightPrice=" + perNightPrice +
                ", room=" + room +
                '}';
    }
}
