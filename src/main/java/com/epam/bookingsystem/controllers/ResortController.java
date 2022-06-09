package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.response.ResortResponseDTO;
import com.epam.bookingsystem.http.ResponseBuilder;
import com.epam.bookingsystem.mapper.impl.ResortMapper;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.services.ResortService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/resorts")
public class ResortController {

    private final ResortMapper resortMapper;
    private final ResortService resortService;

    public ResortController(ResortService resortService, ResortMapper resortMapper) {
        this.resortService = resortService;
        this.resortMapper = resortMapper;
    }

    @PostMapping("/hotel-registration")
    public ResponseEntity<ResortResponseDTO> addResort(@RequestPart("resort") ResortRequestDTO resortRequestDTO,
                                                       @RequestPart("files") List<MultipartFile> files)  {
     Resort resort = resortService.addResort(resortRequestDTO, files);
        return ResponseBuilder.build(HttpStatus.OK, resort, resortMapper);

    }



}
