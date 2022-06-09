package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.mapper.impl.requestDTO.ResortRequestDTOMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.repository.ResortRepository;
import com.epam.bookingsystem.services.ResortNumberService;
import com.epam.bookingsystem.services.ResortService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ResortServiceImpl implements ResortService {
    private final ResortRepository resortRepository;
    private final ResortNumberService resortNumberService;

    public ResortServiceImpl(ResortRepository resortRepository, ResortNumberService resortNumberService) {
        this.resortRepository = resortRepository;
        this.resortNumberService = resortNumberService;
    }


    @Override
    public Resort addResort(ResortRequestDTO resortRequestDTO, List<MultipartFile> files) {
        List<Room> rooms = resortNumberService.addResortNumber(resortRequestDTO, files);
        Resort resort = ResortRequestDTOMapper.resortRequestDTOtoResort(resortRequestDTO);
        resort.setRoom(rooms);
        resortRepository.save(resort);
        System.out.println("It is successfully");
        return resort;
    }
}
