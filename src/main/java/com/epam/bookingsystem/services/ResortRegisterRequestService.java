package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.response.ResortRegisterRequestResponseDTO;
import com.epam.bookingsystem.model.ResortRegisterRequest;

import java.util.List;

public interface ResortRegisterRequestService {
    List<ResortRegisterRequestResponseDTO> getAll();
}
