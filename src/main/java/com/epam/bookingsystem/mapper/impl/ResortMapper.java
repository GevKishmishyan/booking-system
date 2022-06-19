package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.response.ResortResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Resort;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ResortMapper implements Mapper<Resort, ResortRequestDTO, ResortResponseDTO> {

    private final AddressMapper addressMapper;
    private final ResortDetailsMapper resortDetailsMapper;
    private final RoomListMapper roomListMapper;
    private final TinMapper tinMapper;
    private final RateMapper rateMapper;
    private final ResortNumberMapper resortNumberMapper;

    public ResortMapper(AddressMapper addressMapper, ResortDetailsMapper resortDetailsMapper, RoomListMapper roomListMapper, TinMapper tinMapper, RateMapper rateMapper, ResortNumberMapper resortNumberMapper) {
        this.addressMapper = addressMapper;
        this.resortDetailsMapper = resortDetailsMapper;
        this.roomListMapper = roomListMapper;
        this.tinMapper = tinMapper;
        this.rateMapper = rateMapper;
        this.resortNumberMapper = resortNumberMapper;
    }

    @Override
    public Resort mapToEntity(ResortRequestDTO resortRequestDTO) {

        Resort resort = new Resort();
        resort.setName(resortRequestDTO.getName());
        resort.setResortType(resortRequestDTO.getResortType());
        resort.setStar(resortRequestDTO.getStar());
        resort.setEmail(resortRequestDTO.getEmail());
        resort.setTelephone(resortRequestDTO.getTelephone());
        resort.setDescription(resortRequestDTO.getDescription());

        resort.setAddress(addressMapper.mapToEntity(resortRequestDTO.getAddressRequestDTO()));
        resort.setRate(rateMapper.mapToEntity(null));
        resort.setResortDetails(resortDetailsMapper.mapToEntity(resortRequestDTO.getResortDetailsRequestDTO()));
        resort.setResortNumbers(resortRequestDTO.getResortNumberRequestDTOList().stream().map(resortNumberMapper::mapToEntity).collect(Collectors.toList()));

        resort.setTin(tinMapper.mapToEntity(resortRequestDTO.getTinRequestDTO()));
        return resort;
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
        resortResponseDTO.setRateResponseDTO(rateMapper.mapToResponseDto(resort.getRate()));
        resortResponseDTO.setResortDetailsResponseDTO(resortDetailsMapper.mapToResponseDto(resort.getResortDetails()));
        resortResponseDTO.setResortNumberResponseDTOList(resort.getResortNumbers().stream().map(resortNumberMapper::mapToResponseDto).collect(Collectors.toList()));
        resortResponseDTO.setTinResponseDTO(tinMapper.mapToResponseDto(resort.getTin()));
        return resortResponseDTO;
    }
}
