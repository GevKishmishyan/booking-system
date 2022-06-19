package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


public class ResortNumberRequestDTO extends RequestDto {
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @NotNull
    private BigDecimal perNightPrice;

    private RoomDetailsRequestDTO roomDetailsRequestDTO;
    private List<RoomRequestDTO> roomRequestDTOList;
//    private List<RoomPictureRequestDTO> roomPictureRequestDTOList;

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

    public RoomDetailsRequestDTO getRoomDetailsRequestDTO() {
        return roomDetailsRequestDTO;
    }

    public void setRoomDetailsRequestDTO(RoomDetailsRequestDTO roomDetailsRequestDTO) {
        this.roomDetailsRequestDTO = roomDetailsRequestDTO;
    }

    public List<RoomRequestDTO> getRoomRequestDTOList() {
        return roomRequestDTOList;
    }

    public void setRoomRequestDTOList(List<RoomRequestDTO> roomRequestDTOList) {
        this.roomRequestDTOList = roomRequestDTOList;
    }

    @Override
    public String toString() {
        return "ResortNumberRequestDTO{" +
                "roomType=" + roomType +
                ", perNightPrice=" + perNightPrice +
                ", roomDetailsRequestDTO=" + roomDetailsRequestDTO +
                ", roomRequestDTOList=" + roomRequestDTOList +
                '}';
    }
}
