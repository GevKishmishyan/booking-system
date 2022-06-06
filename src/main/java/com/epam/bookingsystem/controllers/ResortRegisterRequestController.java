package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.response.ResortRegisterRequestResponseDTO;
import com.epam.bookingsystem.http.ResponseBuilder;
import com.epam.bookingsystem.mapper.impl.ResortRegisterRequestMapper;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import com.epam.bookingsystem.repository.ResortRepository;
import com.epam.bookingsystem.repository.RoomRepository;
import com.epam.bookingsystem.services.ResortRegisterRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/resort-register-requests")
public class ResortRegisterRequestController {

    final ResortRegisterRequestMapper resortRegisterRequestMapper;
    final ResortRegisterRequestService resortRegisterRequestService;
    final ResortRepository resortRepository;
    final RoomRepository roomRepository;

    public ResortRegisterRequestController(ResortRegisterRequestService resortRegisterRequestService, ResortRepository resortRepository, RoomRepository roomRepository, ResortRegisterRequestMapper resortRegisterRequestMapper) {
        this.resortRegisterRequestService = resortRegisterRequestService;
        this.resortRepository = resortRepository;
        this.roomRepository = roomRepository;
        this.resortRegisterRequestMapper = resortRegisterRequestMapper;
    }

    @GetMapping
    public ResponseEntity<List<ResortRegisterRequestResponseDTO>> getAll() {
        List<ResortRegisterRequest> resortRegisterRequestList = resortRegisterRequestService.getAll();
        return ResponseBuilder.build(HttpStatus.OK, resortRegisterRequestList, resortRegisterRequestMapper);
    }

}
