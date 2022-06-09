package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.mapper.impl.requestDTO.ResortNumberRequestDTOMapper;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.model.RoomPicture;
import com.epam.bookingsystem.repository.ResortNumberRepository;
import com.epam.bookingsystem.services.ResortNumberService;
import com.epam.bookingsystem.services.RoomPictureService;
import com.epam.bookingsystem.services.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ResortNumberServiceImpl implements ResortNumberService {
    private final ResortNumberRepository resortNumberRepository;
    private final RoomPictureService roomPictureService;
    private final RoomService roomService;

    public ResortNumberServiceImpl(ResortNumberRepository resortNumberRepository, RoomPictureService roomPictureService, RoomService roomService) {
        this.resortNumberRepository = resortNumberRepository;
        this.roomPictureService = roomPictureService;
        this.roomService = roomService;
    }

    @Override
    public List<Room> addResortNumber(ResortRequestDTO resortRequestDTO, List<MultipartFile> files) {
        List<RoomPicture> roomPictures = roomPictureService.addPictures(files);
        List<Room> rooms = roomService.addrooms(resortRequestDTO.getRoomListRequestDTO());

        ResortNumber resortNumber = ResortNumberRequestDTOMapper.resortNumberRequestDTOResortNumber(resortRequestDTO);
        resortNumber.setRoomPictures(roomPictures);
        resortNumber.setRooms(rooms);
        resortNumberRepository.save(resortNumber);
        return rooms;
    }
}
