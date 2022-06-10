package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.repository.RoomRepository;
import com.epam.bookingsystem.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> addrooms(List<Room> roomList) {
       return  roomRepository.saveAll(roomList);
    }
}
