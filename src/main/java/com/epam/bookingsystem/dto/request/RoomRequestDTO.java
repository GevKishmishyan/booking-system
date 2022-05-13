package com.epam.bookingsystem.dto.request;

import com.sun.istack.NotNull;

public class RoomRequestDTO {
    @NotNull
    private Integer roomNumber;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
