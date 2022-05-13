package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ResortGeneralRequestDTO;
import com.epam.bookingsystem.model.Address;

public interface AddressService {
    Address addAddress(ResortGeneralRequestDTO resortGeneralRequestDTO);
}
