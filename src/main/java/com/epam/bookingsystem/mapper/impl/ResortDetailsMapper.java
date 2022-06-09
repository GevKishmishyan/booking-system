package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortDetailsRequestDTO;
import com.epam.bookingsystem.dto.response.ResortDetailsResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.ResortDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResortDetailsMapper implements Mapper<ResortDetails, ResortDetailsRequestDTO, ResortDetailsResponseDTO> {
    @Override
    public ResortDetails mapToEntity(ResortDetailsRequestDTO resortDetailsRequestDTO) {
        return null;
    }

    @Override
    public ResortDetailsResponseDTO mapToResponseDto(ResortDetails resortDetails) {

        ResortDetailsResponseDTO resortDetailsResponseDTO = new ResortDetailsResponseDTO();
        resortDetailsResponseDTO.setAirportShuttle(resortDetails.isAirportShuttle());
        resortDetailsResponseDTO.setFreeWiFi(resortDetails.isFreeWiFi());
        resortDetailsResponseDTO.setBar(resortDetails.isBar());
        resortDetailsResponseDTO.setBreakfast(resortDetails.isBreakfast());
        resortDetailsResponseDTO.setTeaCoffeeMaker(resortDetails.isTeaCoffeeMaker());
        resortDetailsResponseDTO.setNonSmokingRooms(resortDetails.isNonSmokingRooms());
        resortDetailsResponseDTO.setSpaAndWellness(resortDetails.isSpaAndWellness());
        resortDetailsResponseDTO.setFitnessCenter(resortDetails.isFitnessCenter());
        resortDetailsResponseDTO.setFacilitiesForDisabledGuests(resortDetails.isFacilitiesForDisabledGuests());
        resortDetailsResponseDTO.setRestaurant(resortDetails.isRestaurant());
        resortDetailsResponseDTO.setPrivateParking(resortDetails.isPrivateParking());
        return resortDetailsResponseDTO;
    }
}
