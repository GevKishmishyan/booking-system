package com.epam.bookingsystem.dto.request;

import com.sun.istack.NotNull;

public class RoomRequestDTO extends RequestDto {

    @NotNull
    private Integer roomNumber;

    public RoomRequestDTO() {
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "RoomRequestDTO{" +
                "roomNumber=" + roomNumber +
                '}';
    }
}
