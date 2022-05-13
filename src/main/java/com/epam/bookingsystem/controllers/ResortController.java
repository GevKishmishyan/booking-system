package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.http.ResponseBuilder;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.services.ResortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resorts")
public class ResortController {
    private final ResortService resortService;

    public ResortController(ResortService resortService) {
        this.resortService = resortService;
    }


    @PostMapping()
    public ResponseEntity<Resort> addResort(ResortRequestDTO resortRequestDTO){
      Resort resort =   resortService.addResort(resortRequestDTO);
        ResponseBuilder.build(resort,bbbbbb,);
    }


}
