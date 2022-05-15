package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.*;
import com.epam.bookingsystem.mapper.impl.requestDTO.ResortRequestDTOMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.repository.ResortRepository;
import com.epam.bookingsystem.services.*;
import org.springframework.stereotype.Service;

@Service
public class ResortServiceImpl implements ResortService {
    private final ResortRepository resortRepository;
    private final TinService tinService;
    private final AddressService addressService;
    private final ResortDetailsService resortDetailsService;
    private final ResortNumberService resortNumberService;
    private final RoomDetailsService roomDetailsService;
    private final RoomPicturesService roomPicturesService;
    private final RoomService roomService;
    private final ResortRegisterRequestService resortRegisterRequestService;

    public ResortServiceImpl(ResortRepository resortRepository, TinService tinService, AddressService addressService, ResortDetailsService resortDetailsService, ResortNumberService resortNumberService, RoomDetailsService roomDetailsService, RoomPicturesService roomPicturesService, RoomService roomService, ResortRegisterRequestService resortRegisterRequestService) {
        this.resortRepository = resortRepository;
        this.addressService = addressService;
        this.resortDetailsService = resortDetailsService;
        this.resortNumberService = resortNumberService;
        this.roomDetailsService = roomDetailsService;
        this.roomPicturesService = roomPicturesService;
        this.roomService = roomService;
        this.tinService = tinService;
        this.resortRegisterRequestService = resortRegisterRequestService;

    }


    @Override
    public Resort addResort(ResortRequestDTO resortRequestDTO) {

        Resort resort = ResortRequestDTOMapper.resortRequestDTOtoResort(resortRequestDTO);
        resortRepository.save(resort);

        AddressRequestDTO addressRequestDTO = resortRequestDTO.getAddressRequestDTO();
        addressService.addAddress(addressRequestDTO,resort);
        TinRequestDTO tinRequestDTO = resortRequestDTO.getTinRequestDTO();
        tinService.addTin(tinRequestDTO,resort);
        ResortDetailsRequestDTO resortDetailsRequestDTO = resortRequestDTO.getResortDetailsRequestDTO();
        resortDetailsService.addResortDetails(resortDetailsRequestDTO,resort);
        RoomRequestDTO roomRequestDTO = resortRequestDTO.getRoomRequestDTO();
        roomService.addRoom(roomRequestDTO,resort);

        ResortNumberRequestDTO resortNumberRequestDTO = resortRequestDTO.getResortNumberRequestDTO();
        Room room = roomService.findRoomByResort(resort).get();
        resortNumberService.addResortNumber(resortNumberRequestDTO, room);

        RoomDetailsRequestDTO roomDetailsRequestDTO = resortRequestDTO.getRoomDetailsRequestDTO();
        ResortNumber resortNumber = resortNumberService.findRoomByRoom(room).get();
        roomDetailsService.addRoomDetails(roomDetailsRequestDTO, resortNumber);

        RoomPicturesRequestDTO roomPicturesRequestDTO = resortRequestDTO.getRoomPicturesRequestDTO();
        roomPicturesService.addRoomPictures(roomPicturesRequestDTO,resortNumber);

        resortRegisterRequestService.addResortRegisterRequest(resort);


        return resort;

    }
}
