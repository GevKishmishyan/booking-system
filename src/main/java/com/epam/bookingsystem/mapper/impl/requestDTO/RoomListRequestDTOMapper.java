package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.RoomRequestDTO;
import com.epam.bookingsystem.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomListRequestDTOMapper {

    public static List<Room> roomRequestDTOtoRoom(List<RoomRequestDTO> roomListRequestDTO) {
        List<Room> allRoom = new ArrayList<>();
        for (RoomRequestDTO roomNum : roomListRequestDTO) {
            Room room = new Room();
            room.setRoomNumber(roomNum.getRoomNumber());
            allRoom.add(room);
        }
        return allRoom;
    }
}
