package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.response.ResortRegisterRequestResponseDTO;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.repository.ResortRepository;
import com.epam.bookingsystem.repository.RoomRepository;
import com.epam.bookingsystem.services.ResortRegisterRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/resort-register-requests")
public class ResortRegisterRequestController {

    final
    ResortRegisterRequestService resortRegisterRequestService;
    final ResortRepository resortRepository;
    final RoomRepository roomRepository;

    public ResortRegisterRequestController(ResortRegisterRequestService resortRegisterRequestService, ResortRepository resortRepository, RoomRepository roomRepository) {
        this.resortRegisterRequestService = resortRegisterRequestService;
        this.resortRepository = resortRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public ResponseEntity<List<ResortRegisterRequest>> getAll() {
      //  List<ResortRegisterRequestResponseDTO> responseDTOList = resortRegisterRequestService.getAll();

       // return ResponseEntity.ok().body(responseDTOList);

        return ResponseEntity.ok(  resortRegisterRequestService.getAll());
    }

}
