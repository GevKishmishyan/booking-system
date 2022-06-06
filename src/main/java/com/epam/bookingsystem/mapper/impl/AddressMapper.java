package com.epam.bookingsystem.mapper.impl;

import com.epam.bookingsystem.dto.request.AddressRequestDTO;
import com.epam.bookingsystem.dto.response.AddressResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<Address, AddressRequestDTO, AddressResponseDTO> {

    @Override
    public Address mapToEntity(AddressRequestDTO addressRequestDTO) {
        return null;
    }

    @Override
    public AddressResponseDTO mapToResponseDto(Address address) {

        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setCountry(address.getCountry());
        addressResponseDTO.setRegion(address.getRegion());
        addressResponseDTO.setSection(address.getSection());
        addressResponseDTO.setAddress(address.getAddress());
        return addressResponseDTO;
    }
}
