package com.epam.bookingsystem.services;


import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.model.Resort;
import org.springframework.http.ResponseEntity;

public interface ResortService {
    ResponseEntity<Resort> addResort(ResortRequestDTO resortRequestDTO);
}
