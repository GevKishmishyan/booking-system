package com.epam.bookingsystem.http;

import com.epam.bookingsystem.dto.request.RequestDto;
import com.epam.bookingsystem.dto.response.ResponseDTO;
import com.epam.bookingsystem.mapper.Mapper;
import com.epam.bookingsystem.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseBuilder {

    public ResponseBuilder() {
    }

    public static ResponseEntity<?> build(HttpStatus status) {
        return ResponseEntity.status(status).build();
    }

    public static <K> ResponseEntity<K> build(HttpStatus status, K body) {
        return ResponseEntity.status(status).body(body);
    }

    public static <T extends BaseEntity, V extends RequestDto, K extends ResponseDTO> ResponseEntity<K> build(HttpStatus status, T body, Mapper<T, V, K> mapper) {
        return ResponseEntity.status(status).body(mapper.mapToResponseDto(body));
    }

    public static <T extends BaseEntity, V extends RequestDto, K extends ResponseDTO> ResponseEntity<Page<K>> build(HttpStatus status, Page<T> page, Mapper<T, V, K> mapper) {
        return ResponseEntity.status(status).body((Page<K>) page.map(mapper::mapToResponseDto));
    }

    public static <T extends BaseEntity, V extends RequestDto, K extends ResponseDTO> ResponseEntity<List<K>> build(HttpStatus status, List<T> list, Mapper<T, V, K> mapper) {
        return ResponseEntity.status(status).body(
                list.stream()
                        .map(mapper::mapToResponseDto)
                        .collect(Collectors.toList())
        );
    }


}