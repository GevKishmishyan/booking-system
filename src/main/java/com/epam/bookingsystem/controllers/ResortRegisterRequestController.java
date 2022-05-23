package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.response.ResortRegisterRequestResponseDTO;
import com.epam.bookingsystem.services.ResortRegisterRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/resort-register-requests")
public class ResortRegisterRequestController {

    final
    ResortRegisterRequestService resortRegisterRequestService;

    public ResortRegisterRequestController(ResortRegisterRequestService resortRegisterRequestService) {
        this.resortRegisterRequestService = resortRegisterRequestService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResortRegisterRequestResponseDTO>> getAll() {
        List<ResortRegisterRequestResponseDTO> responseDTOList = resortRegisterRequestService.getAll();
        return ResponseEntity.ok().body(responseDTOList);
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<ResortRegisterRequestResponseDTO>> getAll() {
//        List<ResortRegisterRequestResponseDTO> responseDTOList = resortRegisterRequestService.getAll();
//        return ResponseEntity.ok().body(responseDTOList);
//    }



}
