package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.AddressRequestDTO;
import com.epam.bookingsystem.dto.request.RoomDetailsRequestDTO;
import com.epam.bookingsystem.model.Address;
import com.epam.bookingsystem.model.RoomDetails;

public class RoomDetailsRequestDTOMapper {

    public static RoomDetails roomDetailsRequestDTOtoRoomDetails (RoomDetailsRequestDTO roomDetailsRequestDTO){
        RoomDetails roomDetails = new RoomDetails();
        roomDetails.setAirConditioner(roomDetailsRequestDTO.isAirConditioner());
        roomDetails.setTelevision(roomDetailsRequestDTO.isTelevision());
        roomDetails.setSofa(roomDetailsRequestDTO.isSofa());
        roomDetails.setTeaTable(roomDetails.isTeaTable());
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

}
