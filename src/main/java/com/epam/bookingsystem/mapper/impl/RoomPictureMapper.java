package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.RoomPictureRequestDTO;
import com.epam.bookingsystem.dto.response.RoomPictureResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.RoomPicture;
import org.springframework.stereotype.Component;

@Component
public class RoomPictureMapper implements Mapper <RoomPicture, RoomPictureRequestDTO, RoomPictureResponseDTO>{

    @Override
    public RoomPicture mapToEntity(RoomPictureRequestDTO roomPictureRequestDTO) {
        RoomPicture roomPicture = new RoomPicture();
        roomPicture.setPicUrl(roomPictureRequestDTO.getPicUrl());
        return roomPicture;
    }

    @Override
    public RoomPictureResponseDTO mapToResponseDto(RoomPicture roomPicture) {
        RoomPictureResponseDTO roomPictureResponseDTO = new RoomPictureResponseDTO();
        roomPictureResponseDTO.setPicUrl(roomPicture.getPicUrl());
        return roomPictureResponseDTO;
    }
}
