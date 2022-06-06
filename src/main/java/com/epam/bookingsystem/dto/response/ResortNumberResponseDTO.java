package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.enums.RoomType;

import java.math.BigDecimal;
import java.util.List;

public class ResortNumberResponseDTO extends ResponseDTO {

    private RoomType roomType;

    private Integer availableCount;

    private BigDecimal perNightPrice;

    private RoomDetailsResponseDTO roomDetailsResponseDTO;

    private List<RoomPictureResponseDTO> roomPictureResponseDTOS;


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

    public RoomDetailsResponseDTO getRoomDetailsResponseDTO() {
        return roomDetailsResponseDTO;
    }

    public void setRoomDetailsResponseDTO(RoomDetailsResponseDTO roomDetailsResponseDTO) {
        this.roomDetailsResponseDTO = roomDetailsResponseDTO;
    }

    public List<RoomPictureResponseDTO> getRoomPicturesResponseDTOS() {
        return roomPictureResponseDTOS;
    }

    public void setRoomPictureResponseDTOS(List<RoomPictureResponseDTO> roomPictureResponseDTOS) {
        this.roomPictureResponseDTOS = roomPictureResponseDTOS;
    }
}
