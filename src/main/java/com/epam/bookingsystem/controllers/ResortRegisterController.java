package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.ResortRegisterCommentRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRegisterRequestDTO;
import com.epam.bookingsystem.dto.response.ResortRegisterResponseDTO;
import com.epam.bookingsystem.http.ResponseBuilder;
import com.epam.bookingsystem.mapper.impl.ResortRegisterCommentMapper;
import com.epam.bookingsystem.mapper.impl.ResortRegisterMapper;
import com.epam.bookingsystem.model.ResortRegister;
import com.epam.bookingsystem.services.ResortRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/resort-registrations")
public class ResortRegisterController {

    private final ResortRegisterCommentMapper resortRegisterCommentMapper;
    private final ResortRegisterService resortRegisterService;
    private final ResortRegisterMapper resortRegisterMapper;

    public ResortRegisterController(ResortRegisterService resortRegisterService, ResortRegisterMapper resortRegisterMapper, ResortRegisterCommentMapper resortRegisterCommentMapper) {
        this.resortRegisterService = resortRegisterService;
        this.resortRegisterMapper = resortRegisterMapper;
        this.resortRegisterCommentMapper = resortRegisterCommentMapper;
    }

    @PostMapping
    public ResponseEntity<ResortRegisterResponseDTO> addNewResortRegisterRequest(@Valid
                                                                                 @RequestPart("resortRegisterRequest") ResortRegisterRequestDTO resortRegisterRequestDTO,
                                                                                 @RequestPart("standard") List<MultipartFile> standard,
                                                                                 @RequestPart("deluxe") List<MultipartFile> lux
    ) {
        ResortRegister savedResortRegister = resortRegisterService.addNewResortRegisterRequest(resortRegisterRequestDTO, standard, lux);
        return ResponseBuilder.build(HttpStatus.OK, savedResortRegister, resortRegisterMapper);
    }

    @GetMapping
    public ResponseEntity<List<ResortRegisterResponseDTO>> getAll(@RequestParam int page, @RequestParam int size) {
        List<ResortRegister> resortRegisterList = resortRegisterService.getAll(page, size);
        return ResponseBuilder.build(HttpStatus.OK, resortRegisterList, resortRegisterMapper);
    }

    @PostMapping("/comments")
    public ResponseEntity<?> addComment(@Valid @RequestBody ResortRegisterCommentRequestDTO resortRegisterCommentRequestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseBuilder.build(HttpStatus.BAD_REQUEST, bindingResult.getAllErrors());
        }
        ResortRegister resortRegister = resortRegisterService.addComment(resortRegisterCommentRequestDTO);
        return ResponseBuilder.build(HttpStatus.OK, resortRegister, resortRegisterMapper);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> conformRegistration(@PathVariable("id") Long resortRegisterId) {
        ResortRegister resortRegister = resortRegisterService.conformRegistration(resortRegisterId);
        return ResponseBuilder.build(HttpStatus.OK, resortRegister, resortRegisterMapper);
    }

}



