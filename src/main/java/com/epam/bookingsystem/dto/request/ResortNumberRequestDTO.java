package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.model.RoomDetails;
import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ResortNumberRequestDTO extends RequestDto {

    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @NotNull
    private BigDecimal perNightPrice;
    private RoomDetails roomDetails;

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
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
}
