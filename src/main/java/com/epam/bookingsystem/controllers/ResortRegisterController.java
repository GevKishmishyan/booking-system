package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.ResortRegisterCommentRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRegisterRequestDTO;
import com.epam.bookingsystem.dto.response.ResortRegisterResponseDTO;
import com.epam.bookingsystem.exception.dto.ErrorDetails;
import com.epam.bookingsystem.http.ResponseBuilder;
import com.epam.bookingsystem.mapper.impl.ResortRegisterCommentMapper;
import com.epam.bookingsystem.mapper.impl.ResortRegisterMapper;
import com.epam.bookingsystem.model.ResortRegister;
import com.epam.bookingsystem.services.ResortRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Date;
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
    public ResponseEntity<ResortRegisterResponseDTO> save(@Valid
                                                          @RequestPart("resortRegisterRequest") ResortRegisterRequestDTO resortRegisterRequestDTO,
                                                          @RequestPart("standard") List<MultipartFile> standard,
                                                          @RequestPart("deluxe") List<MultipartFile> lux
    ) {
        ResortRegister savedResortRegister = resortRegisterService.save(resortRegisterRequestDTO, standard, lux);
        return ResponseBuilder.build(HttpStatus.OK, savedResortRegister, resortRegisterMapper);
    }


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ResortRegister> resortRegisterList = resortRegisterService.getAll();
        return ResponseBuilder.build(HttpStatus.OK, resortRegisterList, resortRegisterMapper);
    }

    // todo ask does this endpoint need in separate controller

    @PostMapping("/{resort-register-id}/comments")
    public ResponseEntity<?> addComment(@PathVariable("resort-register-id") Long id,
                                        @RequestBody ResortRegisterCommentRequestDTO resortRegisterCommentRequestDTO) {
        System.out.println("add comment " + resortRegisterCommentRequestDTO);
        ResortRegister resortRegister = resortRegisterService.addComment(id, resortRegisterCommentRequestDTO);
        return ResponseBuilder.build(HttpStatus.OK, resortRegister, resortRegisterMapper);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> conformRegistration(@PathVariable("id") Long resortRegisterId){
        System.out.println("conformRegistration" + resortRegisterId);
       ResortRegister resortRegister = resortRegisterService.conformRegistration(resortRegisterId);
       return ResponseBuilder.build(HttpStatus.OK,resortRegister,resortRegisterMapper);
    }

    @ExceptionHandler()
    protected ResponseEntity<ErrorDetails> handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest request) {
        log.error("MethodArgumentNotValidException handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                exception.getMessage(), request.getDescription(false), 400);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

}



