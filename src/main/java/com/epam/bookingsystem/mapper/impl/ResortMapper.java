package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.response.ResortResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Resort;
import org.springframework.stereotype.Component;

@Component
public class ResortMapper implements Mapper<Resort, ResortRequestDTO, ResortResponseDTO> {

    private final AddressMapper addressMapper;
    private final ResortDetailsMapper resortDetailsMapper;
    private final RoomListMapper roomListMapper;
    private final TinMapper tinMapper;

    public ResortMapper(AddressMapper addressMapper, ResortDetailsMapper resortDetailsMapper, RoomListMapper roomListMapper, TinMapper tinMapper) {
        this.addressMapper = addressMapper;
        this.resortDetailsMapper = resortDetailsMapper;
        this.roomListMapper = roomListMapper;
        this.tinMapper = tinMapper;
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
