//package com.epam.bookingsystem.services.impl;
//
//import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
//import com.epam.bookingsystem.dto.request.ResortRequestDTO;
//import com.epam.bookingsystem.dto.requestDTO.ResortNumberRequestDTOMapper;
//import com.epam.bookingsystem.dto.requestDTO.RoomRequestDTOMapper;
//import com.epam.bookingsystem.model.ResortNumber;
//import com.epam.bookingsystem.model.Room;
//import com.epam.bookingsystem.repository.ResortNumberRepository;
//import com.epam.bookingsystem.services.ResortNumberService;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ResortNumberServiceImpl implements ResortNumberService {
//    private final ResortNumberRepository resortNumberRepository;
//
//    public ResortNumberServiceImpl(ResortNumberRepository resortNumberRepository) {
//        this.resortNumberRepository = resortNumberRepository;
//    }
//
//    @Override
//    public ResortNumber addResortNumber(ResortNumberRequestDTO resortNumberRequestDTO, Room room) {
//        ResortNumber resortNumber = ResortNumberRequestDTOMapper.resortNumberRequestDTOResortNumber(resortNumberRequestDTO);
//        resortNumber.setRoom(room);
//        resortNumberRepository.save(resortNumber);
//        return resortNumber;
//    }
//
//    @Override
//    public Optional<ResortNumber> findRoomByRoom(Room room) {
//        return resortNumberRepository.findRoomByRoom(room);
//    }
//}