package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.RoomRequestDTO;
import com.epam.bookingsystem.mapper.impl.requestDTO.RoomRequestDTOMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.repository.RoomRepository;
import com.epam.bookingsystem.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room addRoom(RoomRequestDTO roomRequestDTO, Resort resort) {
        Room room = RoomRequestDTOMapper.roomRequestDTOtoRoom(roomRequestDTO);
        room.setResort(resort);
        roomRepository.save(room);
        return room;
    }

    @Override
    public Optional<Room> findRoomByResort(Resort resort) {
        return roomRepository.findRoomByResort(resort);
    }


}
