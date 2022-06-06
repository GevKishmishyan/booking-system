package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortRegisterRequest_RequestDTO;
import com.epam.bookingsystem.dto.response.ResortRegisterRequestResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class ResortRegisterRequestMapper implements Mapper<ResortRegisterRequest, ResortRegisterRequest_RequestDTO, ResortRegisterRequestResponseDTO> {

    private final ResortMapper resortMapper;

    public ResortRegisterRequestMapper(ResortMapper resortMapper) {
        this.resortMapper = resortMapper;
    }

    @Override
    public ResortRegisterRequest mapToEntity(ResortRegisterRequest_RequestDTO resortRegisterRequest_requestDTO) {
        return null;
    }

    @Override
    public ResortRegisterRequestResponseDTO mapToResponseDto(ResortRegisterRequest resortRegisterRequest) {

        ResortRegisterRequestResponseDTO resortRegisterRequestResponseDTO = new ResortRegisterRequestResponseDTO();
        resortRegisterRequestResponseDTO.setResortRegisterStatus(resortRegisterRequest.getRegisterStatus());
        resortRegisterRequestResponseDTO.setResortResponseDTO(resortMapper.mapToResponseDto(resortRegisterRequest.getResort()));
        return resortRegisterRequestResponseDTO;
    }
}
