package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.model.ResortNumber;

public class ResortNumberRequestDTOMapper {
    public static ResortNumber resortNumberRequestDTOResortNumber(ResortRequestDTO resortRequestDTO) {

        ResortNumberRequestDTO resortNumberRequestDTO = resortRequestDTO.getResortNumberRequestDTO();
        ResortNumber resortNumber = new ResortNumber();
        resortNumber.setRoomType(resortNumberRequestDTO.getRoomType());
        resortNumber.setPerNightPrice(resortNumberRequestDTO.getPerNightPrice());
        resortNumber.setRoomDetails(resortNumberRequestDTO.getRoomDetails());
        return resortNumber;
    }
}
