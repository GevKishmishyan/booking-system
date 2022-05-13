package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.AddressRequestDTO;
import com.epam.bookingsystem.model.Address;

public class AddressRequestDTOMapper {

    public static Address addressRequestDTOtoAddress (AddressRequestDTO addressRequestDTO){
        Address address = new Address();
        address.setCountry(addressRequestDTO.getCountry());
        address.setRegion(addressRequestDTO.getRegion());
        address.setSection(addressRequestDTO.getSection());
        address.setAddress(addressRequestDTO.getAddress());
        return address;
    }

}
