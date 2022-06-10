package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.RateRequestDTO;
import com.epam.bookingsystem.dto.response.RateResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Rate;
import org.springframework.stereotype.Component;

@Component
public class RateMapper implements Mapper<Rate, RateRequestDTO, RateResponseDTO> {
    @Override
    public Rate mapToEntity(RateRequestDTO rateRequestDTO) {
        return new Rate();
    }

    @Override
    public RateResponseDTO mapToResponseDto(Rate rate) {

        RateResponseDTO rateResponseDTO = new RateResponseDTO();
        rateResponseDTO.setRating(rate.getRating());
        rateResponseDTO.setTotalRate(rate.getTotalRate());
        rateResponseDTO.setRatesCount(rate.getRatesCount());
        return rateResponseDTO;
    }
}
