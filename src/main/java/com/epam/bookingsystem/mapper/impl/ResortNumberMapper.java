package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.dto.request.RoomDetailsRequestDTO;
import com.epam.bookingsystem.dto.response.ResortNumberResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.ResortNumber;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ResortNumberMapper implements Mapper<ResortNumber, ResortNumberRequestDTO, ResortNumberResponseDTO> {
    private final RoomDetailsMapper roomDetailsMapper;
    private final RoomMapper roomMapper;
    private final RoomPictureMapper roomPictureMapper;

    public ResortNumberMapper(RoomDetailsMapper roomDetailsMapper, RoomListMapper roomListMapper, RoomMapper roomMapper, RoomPictureMapper roomPictureMapper) {
        this.roomDetailsMapper = roomDetailsMapper;
        this.roomMapper = roomMapper;
        this.roomPictureMapper = roomPictureMapper;
    }


    @Override
    public ResortNumber mapToEntity(ResortNumberRequestDTO resortNumberRequestDTO) {
        ResortNumber resortNumber = new ResortNumber();
        resortNumber.setRoomDetails(roomDetailsMapper.mapToEntity(resortNumberRequestDTO.getRoomDetailsRequestDTO()));
        resortNumber.setRooms(resortNumberRequestDTO.getRoomRequestDTOList().stream()
                .map(roomMapper::mapToEntity).collect(Collectors.toList()));
        //todo replace this code
//        resortNumber.setRoomPictures(resortNumberRequestDTO.getRoomPictureRequestDTOList().stream()
//                .map(roomPictureMapper::mapToEntity).collect(Collectors.toList()));
        resortNumber.setRoomType(resortNumberRequestDTO.getRoomType());
        resortNumber.setPerNightPrice(resortNumberRequestDTO.getPerNightPrice());
        return resortNumber;
    }

    @Override
    public ResortNumberResponseDTO mapToResponseDto(ResortNumber resortNumber) {
        ResortNumberResponseDTO resortNumberResponseDTO = new ResortNumberResponseDTO();
        resortNumberResponseDTO.setRoomType(resortNumber.getRoomType());
        resortNumberResponseDTO.setPerNightPrice(resortNumber.getPerNightPrice());
        resortNumberResponseDTO.setRoomDetailsResponseDTO(roomDetailsMapper.mapToResponseDto(resortNumber.getRoomDetails()));
        resortNumberResponseDTO.setRoomResponseDTOList(resortNumber.getRooms().stream()
                .map(roomMapper::mapToResponseDto).collect(Collectors.toList()));
        resortNumberResponseDTO.setRoomPictureResponseDTOS(resortNumber.getRoomPictures().stream()
                .map(roomPictureMapper::mapToResponseDto).collect(Collectors.toList()));

        return resortNumberResponseDTO;

    }
}
