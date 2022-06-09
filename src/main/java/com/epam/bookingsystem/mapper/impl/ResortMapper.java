package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.response.ResortResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Resort;

public class ResortMapper implements Mapper<Resort, ResortRequestDTO, ResortResponseDTO> {
    private final AddressMapper addressMapper;
    private final ResortDetailsMapper resortDetailsMapper;
    private final TinMapper tinMapper;
    private final RoomListMapper roomListMapper;

    public ResortMapper(AddressMapper addressMapper, ResortDetailsMapper resortDetailsMapper, TinMapper tinMapper, RoomListMapper roomListMapper) {
        this.addressMapper = addressMapper;
        this.resortDetailsMapper = resortDetailsMapper;
        this.tinMapper = tinMapper;
        this.roomListMapper = roomListMapper;
    }

    @Override
    public Resort mapToEntity(ResortRequestDTO resortRequestDTO) {
        return null;

    }

    @Override
    public ResortResponseDTO mapToResponseDto(Resort resort) {

        ResortResponseDTO resortResponseDTO = new ResortResponseDTO();
        resortResponseDTO.setName(resort.getName());
        resortResponseDTO.setResortType(resort.getResortType());
        resortResponseDTO.setStar(resort.getStar());
        resortResponseDTO.setEmail(resort.getEmail());
        resortResponseDTO.setTelephone(resort.getTelephone());
        resortResponseDTO.setDescription(resort.getDescription());

        resortResponseDTO.setAddressResponseDTO(addressMapper.mapToResponseDto(resort.getAddress()));
        resortResponseDTO.setResortDetailsResponseDTO(resortDetailsMapper.mapToResponseDto(resort.getResortDetails()));
        resortResponseDTO.setRooms(roomListMapper.mapToResponseDtoList(resort.getRoom()));
        resortResponseDTO.setTinResponseDTO(tinMapper.mapToResponseDto(resort.getTin()));
        return resortResponseDTO;
    }
}
