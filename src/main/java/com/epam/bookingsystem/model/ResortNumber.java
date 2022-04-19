package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "resort_number")
public class ResortNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomType type;
    @OneToOne
    private RoomDetails roomDetails;
    @NotNull
    @Column(name = "available_count")
    private Integer availableCount;
    @NotNull
    @Column(name = "per_night_price")
    private BigDecimal perNightPrice;

    public ResortNumber(long id, RoomType type,
                        RoomDetails roomDetails,
                        @NotNull Integer availableCount,
                        @NotNull BigDecimal perNightPrice) {
        this.id = id;
        this.type = type;
        this.roomDetails = roomDetails;
        this.availableCount = availableCount;
        this.perNightPrice = perNightPrice;
    }

    public ResortNumber() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResortNumber that = (ResortNumber) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(roomDetails, that.roomDetails) && Objects.equals(availableCount, that.availableCount) && Objects.equals(perNightPrice, that.perNightPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, roomDetails, availableCount, perNightPrice);
    }

    @Override
    public String toString() {
        return "ResortNumber{" +
                "id=" + id +
                ", type=" + type +
                ", roomDetails=" + roomDetails +
                ", availableCount=" + availableCount +
                ", perNightPrice=" + perNightPrice +
                '}';
    }
}
