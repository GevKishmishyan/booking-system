package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ResortNumberRequestDTO {
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @NotNull
    private Integer availableCount;
    @NotNull
    private BigDecimal perNightPrice;

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
}
