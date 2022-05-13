package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.ResortDetailsRequestDTO;
import com.epam.bookingsystem.model.ResortDetails;

public class ResortDetailsRequestDTOMapper {

    public static ResortDetails ResortDetailsRequestDTOtoResortDetail (ResortDetailsRequestDTO resortDetailsRequestDTO){
        ResortDetails resortDetails = new ResortDetails();
        resortDetails.setAirportShuttle(resortDetailsRequestDTO.isAirportShuttle());
        resortDetails.setFreeWiFi(resortDetailsRequestDTO.isFreeWiFi());
        resortDetails.setBar(resortDetailsRequestDTO.isBar());
        resortDetails.setBreakfast(resortDetailsRequestDTO.isBreakfast());
        resortDetails.setTeaCoffeeMaker(resortDetailsRequestDTO.isTeaCoffeeMaker());
        resortDetails.setNonSmokingRooms(resortDetailsRequestDTO.isNonSmokingRooms());
        resortDetails.setSpaAndWellness(resortDetailsRequestDTO.isNonSmokingRooms());
        resortDetails.setFitnessCenter(resortDetailsRequestDTO.isSpaAndWellness());
        resortDetails.setFacilitiesForDisabledGuests(resortDetailsRequestDTO.isFacilitiesForDisabledGuests());
        resortDetails.setRestaurant(resortDetailsRequestDTO.isRestaurant());
        resortDetails.setPrivateParking(resortDetailsRequestDTO.isPrivateParking());
        return resortDetails;
    }

}
