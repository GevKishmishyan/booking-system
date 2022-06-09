package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.model.Resort;

public class ResortRequestDTOMapper {

    public static Resort resortRequestDTOtoResort (ResortRequestDTO resortRequestDTO){
        Resort resort = new Resort();
        resort.setName(resortRequestDTO.getName());
        resort.setResortType(resortRequestDTO.getResortType());
        resort.setStar(resortRequestDTO.getStar());
        resort.setEmail(resortRequestDTO.getEmail());
        resort.setTelephone(resortRequestDTO.getTelephone());
        resort.setDescription(resortRequestDTO.getDescription());
        resort.setAddress(resortRequestDTO.getAddress());
        resort.setResortDetails(resortRequestDTO.getResortDetails());
        resort.setTin(resortRequestDTO.getTin());
        return resort;
    }
}
