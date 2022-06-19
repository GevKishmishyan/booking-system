package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortRegisterRequestDTO;
import com.epam.bookingsystem.dto.response.ResortRegisterResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.ResortRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResortRegisterMapper implements Mapper<ResortRegister, ResortRegisterRequestDTO, ResortRegisterResponseDTO> {

    @Autowired
    ResortMapper resortMapper;

    @Override
    public ResortRegister mapToEntity(ResortRegisterRequestDTO resortRegisterRequestDTO) {
        ResortRegister resortRegister = new ResortRegister();
        resortRegister.setResort(resortMapper.mapToEntity(resortRegisterRequestDTO.getResortRequestDTO()));
        return resortRegister;
    }

    @Override
    public ResortRegisterResponseDTO mapToResponseDto(ResortRegister resortRegister) {
        ResortRegisterResponseDTO resortRegisterResponseDTO = new ResortRegisterResponseDTO();
        resortRegisterResponseDTO.setId(resortRegister.getId());
        resortRegisterResponseDTO.setResortResponseDTO(resortMapper.mapToResponseDto(resortRegister.getResort()));
        resortRegisterResponseDTO.setResortRegisterStatus(resortRegister.getResortRegisterStatus());
        resortRegisterResponseDTO.setResortRegisterCommentList(resortRegister.getResortRegisterCommentList());
        resortRegisterResponseDTO.setCreatedAt(resortRegister.getCreatedAt());
        return resortRegisterResponseDTO;
    }
}
