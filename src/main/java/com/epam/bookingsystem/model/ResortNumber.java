package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "resort_number")
public class ResortNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    private List<String> pictures;
    @OneToOne
    private RoomDetails roomDetails;
    @NotNull
    private Integer availableCount;
    @NotNull
    private BigDecimal perNightPrice;

    public ResortNumber(UUID id, RoomType type,
                        List<String> pictures,
                        RoomDetails roomDetails,
                        @NotNull Integer availableCount,
                        @NotNull BigDecimal perNightPrice) {
        this.id = id;
        this.type = type;
        this.pictures = pictures;
        this.roomDetails = roomDetails;
        this.availableCount = availableCount;
        this.perNightPrice = perNightPrice;
    }

    public ResortNumber() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
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
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(pictures, that.pictures) && Objects.equals(roomDetails, that.roomDetails) && Objects.equals(availableCount, that.availableCount) && Objects.equals(perNightPrice, that.perNightPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, pictures, roomDetails, availableCount, perNightPrice);
    }

    @Override
    public String toString() {
        return "ResortNumber{" +
                "id=" + id +
                ", type=" + type +
                ", pictures=" + pictures +
                ", roomDetails=" + roomDetails +
                ", availableCount=" + availableCount +
                ", perNightPrice=" + perNightPrice +
                '}';
    }
}
