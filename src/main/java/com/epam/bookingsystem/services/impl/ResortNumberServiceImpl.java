package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.mapper.impl.ResortNumberMapper;

import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.model.enums.RoomType;
import com.epam.bookingsystem.repository.ResortNumberRepository;
import com.epam.bookingsystem.services.ResortNumberService;
import com.epam.bookingsystem.services.RoomPictureService;
import com.epam.bookingsystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResortNumberServiceImpl implements ResortNumberService {

    final ResortNumberRepository resortNumberRepository;
    final RoomPictureService roomPictureService;
    final RoomService roomService;
    final ResortNumberMapper resortNumberMapper;



    public ResortNumberServiceImpl(ResortNumberRepository resortNumberRepository, RoomPictureService roomPictureService, RoomService roomService, ResortNumberMapper resortNumberMapper) {
        this.resortNumberRepository = resortNumberRepository;
        this.roomPictureService = roomPictureService;
        this.roomService = roomService;
        this.resortNumberMapper = resortNumberMapper;
    }

    @Override
    public List<ResortNumber> addResortNumber(List<ResortNumberRequestDTO> resortNumberRequestDTOList, List<MultipartFile> standard, List<MultipartFile> lux) {
//        List<Room> allRoom = new ArrayList<>();


        List<ResortNumber> resortNumbersList = resortNumberRequestDTOList.stream().map(resortNumberMapper::mapToEntity).collect(Collectors.toList());
        for (ResortNumber resNum:resortNumbersList) {
            if (resNum.getRoomType().equals(RoomType.STANDARD)){
                List<Room> roomsStandard = resNum.getRooms();
                roomService.addrooms(roomsStandard);
                resNum.setRooms(roomsStandard);
                resNum.setRoomPictures(roomPictureService.addPictures(standard));
                resortNumberRepository.save(resNum);
            }else {
                if (resNum.getRoomType().equals(RoomType.DELUXE)) {
                    List<Room> roomsDeluxe = resNum.getRooms();
                    roomService.addrooms(roomsDeluxe);
                    resNum.setRooms(roomsDeluxe);
                    resNum.setRoomPictures(roomPictureService.addPictures(lux));
                    resortNumberRepository.save(resNum);
                }
            }
        }
        return resortNumbersList;

    }
}
