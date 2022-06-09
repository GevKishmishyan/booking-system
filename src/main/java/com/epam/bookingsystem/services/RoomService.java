package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.RoomRequestDTO;
import com.epam.bookingsystem.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> addrooms(List<RoomRequestDTO> roomListRequestDTO);
}
