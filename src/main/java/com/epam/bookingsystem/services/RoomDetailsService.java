package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.request.RoomDetailsRequestDTO;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.RoomDetails;

public interface RoomDetailsService {
    RoomDetails addRoomDetails(RoomDetailsRequestDTO roomDetailsRequestDTO, ResortNumber resortNumber);
}
