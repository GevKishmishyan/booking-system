package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.ResortGeneralRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.request.TinRequestDTO;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.repository.ResortRepository;
import com.epam.bookingsystem.services.ResortService;
import com.epam.bookingsystem.services.TinService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResortServiceImpl implements ResortService {
    private final ResortRepository resortRepository;
    private final TinService tinService;

    public ResortServiceImpl(ResortRepository resortRepository) {
        this.resortRepository = resortRepository;
    }

    @Override
    public Resort addResort(ResortGeneralRequestDTO resortGeneralRequestDTO) {
       TinRequestDTO tinRequestDTO = resortGeneralRequestDTO.getTinRequestDTO();
       tinService.add(tinRequestDTO);

        return resortRepository.save(resortRequestDTO);
    }
}
