package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.enums.RoomType;

import java.math.BigDecimal;
import java.util.List;

public class ResortNumberResponseDTO extends ResponseDTO {

    private RoomType roomType;

    private BigDecimal perNightPrice;

    private RoomDetailsResponseDTO roomDetailsResponseDTO;

    private List<RoomResponseDTO> roomResponseDTOList;

    private List<RoomPictureResponseDTO> roomPictureResponseDTOS;



    public List<RoomResponseDTO> getRoomResponseDTOList() {
        return roomResponseDTOList;
    }

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

    public RoomDetailsResponseDTO getRoomDetailsResponseDTO() {
        return roomDetailsResponseDTO;
    }

    public void setRoomDetailsResponseDTO(RoomDetailsResponseDTO roomDetailsResponseDTO) {
        this.roomDetailsResponseDTO = roomDetailsResponseDTO;
    }

    public void setRoomResponseDTOList(List<RoomResponseDTO> roomResponseDTOList) {
        this.roomResponseDTOList = roomResponseDTOList;
    }

    public List<RoomPictureResponseDTO> getRoomPictureResponseDTOS() {
        return roomPictureResponseDTOS;
    }

    public void setRoomPictureResponseDTOS(List<RoomPictureResponseDTO> roomPictureResponseDTOS) {
        this.roomPictureResponseDTOS = roomPictureResponseDTOS;
    }
}
