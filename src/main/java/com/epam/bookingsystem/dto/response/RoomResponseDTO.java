package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.Booking;

import java.util.List;

public class RoomResponseDTO extends ResponseDTO {
    private Integer roomNumber;

    public RoomResponseDTO() {
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
