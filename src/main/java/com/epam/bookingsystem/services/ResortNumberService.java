package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.Room;

import java.util.Optional;

public interface ResortNumberService {

    ResortNumber addResortNumber(ResortNumberRequestDTO resortNumberRequestDTO, Room room);
    Optional<ResortNumber> findRoomByRoom(Room room);
}
