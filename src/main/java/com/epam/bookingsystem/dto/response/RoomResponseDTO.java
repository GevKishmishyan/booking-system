package com.epam.bookingsystem.dto.response;

public class RoomResponseDTO {

    private Integer roomNumber;
    private ResortNumberResponseDTO resortNumberResponseDTO;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ResortNumberResponseDTO getResortNumberResponseDTO() {
        return resortNumberResponseDTO;
    }

    public void setResortNumberResponseDTO(ResortNumberResponseDTO resortNumberResponseDTO) {
        this.resortNumberResponseDTO = resortNumberResponseDTO;
    }
}
