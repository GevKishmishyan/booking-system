package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.request.RoomDetailsRequestDTO;
import com.epam.bookingsystem.mapper.impl.requestDTO.ResortNumberRequestDTOMapper;
import com.epam.bookingsystem.mapper.impl.requestDTO.RoomDetailsRequestDTOMapper;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.RoomDetails;
import com.epam.bookingsystem.repository.RoomDetailsRepository;
import com.epam.bookingsystem.services.RoomDetailsService;
import org.springframework.stereotype.Service;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {
    private final RoomDetailsRepository roomDetailsRepository;

    public RoomDetailsServiceImpl(RoomDetailsRepository roomDetailsRepository) {
        this.roomDetailsRepository = roomDetailsRepository;
    }

    @Override
    public RoomDetails addRoomDetails(RoomDetailsRequestDTO roomDetailsRequestDTO, ResortNumber resortNumber) {
        RoomDetails roomDetails = RoomDetailsRequestDTOMapper.roomDetailsRequestDTOtoRoomDetails(roomDetailsRequestDTO);
        roomDetails.setResortNumber(resortNumber);
        roomDetailsRepository.save(roomDetails);
        return roomDetails;
    }
}
