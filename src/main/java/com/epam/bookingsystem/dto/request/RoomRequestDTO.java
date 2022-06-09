package com.epam.bookingsystem.dto.request;

public class RoomRequestDTO extends RequestDto{

    private Integer roomNumber;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
