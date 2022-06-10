package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.RoomDetailsRequestDTO;
import com.epam.bookingsystem.dto.response.RoomDetailsResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.RoomDetails;
import org.springframework.stereotype.Component;

@Component
public class RoomDetailsMapper implements Mapper<RoomDetails, RoomDetailsRequestDTO, RoomDetailsResponseDTO> {
    @Override
    public RoomDetails mapToEntity(RoomDetailsRequestDTO roomDetailsRequestDTO) {
        RoomDetails roomDetails = new RoomDetails();
        roomDetails.setAirConditioner(roomDetailsRequestDTO.isAirConditioner());
        roomDetails.setTelevision(roomDetailsRequestDTO.isTelevision());
        roomDetails.setSofa(roomDetailsRequestDTO.isSofa());
        roomDetails.setTeaTable(roomDetailsRequestDTO.isTeaTable());
        roomDetails.setShower(roomDetailsRequestDTO.isShower());
        roomDetails.setBathtub(roomDetailsRequestDTO.isBathtub());
        roomDetails.setBathAccessories(roomDetailsRequestDTO.isBathAccessories());
        roomDetails.setHairdryer(roomDetailsRequestDTO.isHairdryer());
        roomDetails.setMinibar(roomDetailsRequestDTO.isMinibar());
        roomDetails.setFridge(roomDetailsRequestDTO.isFridge());
        roomDetails.setDishes(roomDetailsRequestDTO.isDishes());
        roomDetails.setElectricKettle(roomDetailsRequestDTO.isElectricKettle());
        return roomDetails;
    }

    @Override
    public RoomDetailsResponseDTO mapToResponseDto(RoomDetails roomDetails) {
        RoomDetailsResponseDTO roomDetailsResponseDTO = new RoomDetailsResponseDTO();
        roomDetailsResponseDTO.setAirConditioner(roomDetails.isAirConditioner());
        roomDetailsResponseDTO.setTelevision(roomDetails.isTelevision());
        roomDetailsResponseDTO.setSofa(roomDetails.isSofa());
        roomDetailsResponseDTO.setTeaTable(roomDetails.isTeaTable());
        roomDetailsResponseDTO.setShower(roomDetails.isShower());
        roomDetailsResponseDTO.setBathtub(roomDetails.isBathtub());
        roomDetailsResponseDTO.setBathAccessories(roomDetails.isBathAccessories());
        roomDetailsResponseDTO.setHairdryer(roomDetails.isHairdryer());
        roomDetailsResponseDTO.setMinibar(roomDetails.isMinibar());
        roomDetailsResponseDTO.setFridge(roomDetails.isFridge());
        roomDetailsResponseDTO.setDishes(roomDetails.isDishes());
        roomDetailsResponseDTO.setElectricKettle(roomDetails.isElectricKettle());
        return roomDetailsResponseDTO;
    }
}
