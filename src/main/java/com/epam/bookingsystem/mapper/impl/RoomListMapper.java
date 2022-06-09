package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.RoomRequestDTO;
import com.epam.bookingsystem.dto.response.RoomResponseDTO;
import com.epam.bookingsystem.model.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomListMapper {

    private final RoomMapper roomMapper;

    public RoomListMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    public List<Room> mapToEntityList(List<RoomRequestDTO> roomRequestDTOList) {
        return null;
    }

    public List<RoomResponseDTO> mapToResponseDtoList(List<Room> roomList) {
        List<RoomResponseDTO> roomResponseDTOList = new ArrayList<RoomResponseDTO>();
        for (Room room : roomList) {
            RoomResponseDTO roomResponseDTO = roomMapper.mapToResponseDto(room);
            roomResponseDTOList.add(roomResponseDTO);
        }
        return roomResponseDTOList;
    }
}
