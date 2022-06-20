package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.mapper.impl.ResortMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortNumber;
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
    private final ResortMapper resortMapper;

    public ResortServiceImpl(ResortRepository resortRepository, ResortNumberService resortNumberService, ResortMapper resortMapper) {
        this.resortRepository = resortRepository;
        this.resortNumberService = resortNumberService;
        this.resortMapper = resortMapper;
    }


    @Override
    public Resort addResort(ResortRequestDTO resortRequestDTO, List<MultipartFile> standard, List<MultipartFile> lux) {

        List<ResortNumber> resortNumbers = resortNumberService.addResortNumber(resortRequestDTO.getResortNumberRequestDTOList(), standard, lux);

        Resort resort = resortMapper.mapToEntity(resortRequestDTO);

        resort.setResortNumbers(resortNumbers);

        resortRepository.save(resort);

        System.out.println("It is successfully");
        return resort;
    }


    @Override
    public boolean acceptRegistration(long id) {
        System.out.println();
        Resort resort = resortRepository.getById(id);
        resort.setActive(true);
        resortRepository.save(resort);
        return true;
    }
}
