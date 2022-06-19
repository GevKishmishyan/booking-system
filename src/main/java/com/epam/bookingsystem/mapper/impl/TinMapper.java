package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.TinRequestDTO;
import com.epam.bookingsystem.dto.response.TinResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Tin;
import org.springframework.stereotype.Component;

@Component
public class TinMapper implements Mapper<Tin, TinRequestDTO, TinResponseDTO> {

    @Override
    public Tin mapToEntity(TinRequestDTO tinRequestDTO) {

        Tin tin = new Tin();
        tin.setSerialNumber(tinRequestDTO.getSerialNumber());
        tin.setDocument(tinRequestDTO.getDocument());
        return tin;
    }

    @Override
    public TinResponseDTO mapToResponseDto(Tin tin) {

        TinResponseDTO tinResponseDTO = new TinResponseDTO();
        tinResponseDTO.setSerialNumber(tin.getSerialNumber());
        tinResponseDTO.setDocument(tin.getDocument());
        return tinResponseDTO;
    }
}
