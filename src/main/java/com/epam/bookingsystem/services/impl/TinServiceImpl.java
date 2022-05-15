package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.request.TinRequestDTO;
import com.epam.bookingsystem.mapper.impl.requestDTO.TinRequestDTOMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.Tin;
import com.epam.bookingsystem.repository.TinRepository;
import com.epam.bookingsystem.services.TinService;
import org.springframework.stereotype.Service;

@Service
public class TinServiceImpl implements TinService {
    private final TinRepository tinRepository;

    public TinServiceImpl(TinRepository tinRepository) {
        this.tinRepository = tinRepository;
    }

    @Override
    public Tin addTin(TinRequestDTO tinRequestDTO, Resort resort) {
        Tin tin = TinRequestDTOMapper.tinRequestDTOtoTin(tinRequestDTO);
        tin.setResort(tin.getResort());
        tinRepository.save(tin);
        return tin;
    }
}
