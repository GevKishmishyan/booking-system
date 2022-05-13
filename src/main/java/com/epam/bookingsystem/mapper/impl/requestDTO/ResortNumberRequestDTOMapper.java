package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.model.ResortNumber;

public class ResortNumberRequestDTOMapper {
    public static ResortNumber resortNumberRequestDTOResortNumber (ResortNumberRequestDTO resortNumberRequestDTO){
        ResortNumber resortNumber = new ResortNumber();
        resortNumber.setAvailableCount(resortNumberRequestDTO.getAvailableCount());
        resortNumber.setPerNightPrice(resortNumberRequestDTO.getPerNightPrice());
        return  resortNumber;
    }
}
