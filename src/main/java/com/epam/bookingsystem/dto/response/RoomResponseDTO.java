package com.epam.bookingsystem.dto.response;

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
