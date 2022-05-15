package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.request.RoomPicturesRequestDTO;
import com.epam.bookingsystem.mapper.impl.requestDTO.ResortNumberRequestDTOMapper;
import com.epam.bookingsystem.mapper.impl.requestDTO.RoomPicturesRequestDTOMapper;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.RoomPictures;
import com.epam.bookingsystem.repository.RoomPicturesRepository;
import com.epam.bookingsystem.services.RoomPicturesService;
import org.springframework.stereotype.Service;

@Service
public class RoomPicturesServiceImpl implements RoomPicturesService {
    private final RoomPicturesRepository roomPicturesRepository;

    public RoomPicturesServiceImpl(RoomPicturesRepository roomPicturesRepository) {
        this.roomPicturesRepository = roomPicturesRepository;
    }

    @Override
    public RoomPictures addRoomPictures(RoomPicturesRequestDTO roomPicturesRequestDTO, ResortNumber resortNumber) {
        RoomPictures roomPictures = RoomPicturesRequestDTOMapper.RoomPicturesRequestDTOtoRoomPictures(roomPicturesRequestDTO);
        roomPictures.setResortNumber(resortNumber);
        roomPicturesRepository.save(roomPictures);
        return roomPictures;
    }
}
