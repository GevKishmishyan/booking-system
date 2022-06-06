package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.RoomRequestDTO;
import com.epam.bookingsystem.dto.response.RoomResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<Room, RoomRequestDTO, RoomResponseDTO> {

    @Override
    public Room mapToEntity(RoomRequestDTO roomRequestDTO) {
        return null;
    }

    @Override
    public RoomResponseDTO mapToResponseDto(Room room) {
        RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
        roomResponseDTO.setRoomNumber(room.getRoomNumber());
        return roomResponseDTO;
    }
}
