package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.exception.dto.ErrorDetails;
import com.epam.bookingsystem.http.ResponseBuilder;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.services.ResortService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/resorts")
public class ResortController {
    private final ResortService resortService;

    public ResortController(ResortService resortService) {
        this.resortService = resortService;
    }


    @PostMapping("/hotel-registration")
    public Resort addResort(@Valid @RequestBody ResortRequestDTO resortRequestDTO) {
        System.out.println(" addResort(ResortRequestDTO resortRequestDTO) ");
        return resortService.addResort(resortRequestDTO);
    }

    @ExceptionHandler()
    protected ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        log.error("Xxxxxxxxxxxxxxx all exception handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                exception.getMessage(), request.getDescription(false), 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

}
