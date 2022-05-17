package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "resort_number")
public class ResortNumber extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @NotNull
    private Integer availableCount;
    @NotNull
    private BigDecimal perNightPrice;
    @OneToOne
    @JoinColumn(name = "id")
    private RoomDetails roomDetails;
    @OneToMany
    @JoinColumn(name = "id")
    private List<RoomPictures> roomPictures;

    public ResortNumber(long id, RoomType roomType, @NotNull Integer availableCount,
                        @NotNull BigDecimal perNightPrice, RoomDetails roomDetails,
                        List<RoomPictures> roomPictures) {
        super(id);
        this.roomType = roomType;
        this.availableCount = availableCount;
        this.perNightPrice = perNightPrice;
        this.roomDetails = roomDetails;
        this.roomPictures = roomPictures;
    }

    public ResortNumber() {
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

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }

    public List<RoomPictures> getRoomPictures() {
        return roomPictures;
    }

    public void setRoomPictures(List<RoomPictures> roomPictures) {
        this.roomPictures = roomPictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResortNumber that = (ResortNumber) o;
        return roomType == that.roomType && Objects.equals(availableCount, that.availableCount) && Objects.equals(perNightPrice, that.perNightPrice) && Objects.equals(roomDetails, that.roomDetails) && Objects.equals(roomPictures, that.roomPictures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType, availableCount, perNightPrice, roomDetails, roomPictures);
    }

    @Override
    public String toString() {
        return "ResortNumber{" +
                "roomType=" + roomType +
                ", availableCount=" + availableCount +
                ", perNightPrice=" + perNightPrice +
                ", roomDetails=" + roomDetails +
                ", roomPictures=" + roomPictures +
                '}';
    }
}
