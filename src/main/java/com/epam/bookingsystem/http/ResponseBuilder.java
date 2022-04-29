package com.epam.bookingsystem.http;

import com.epam.bookingsystem.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseBuilder {
    public ResponseBuilder() {
    }

    public  static <T, V> ResponseEntity<V> build(HttpStatus status, T body, Mapper<T, V> mapper){
        return ResponseEntity.status(status).body(mapper.mapDTO(body));
    }

    public  static <T, V>ResponseEntity<Page<V>> build(HttpStatus status, Page<T> page, Mapper<T, V> mapper){
        return ResponseEntity.status(status).body(page.map(mapper::mapDTO));
    }

    public static <T, V> ResponseEntity<List<V>> build(HttpStatus status, List<T> list, Mapper<T, V> mapper){
        return ResponseEntity.status(status).body(
                list.stream()
                        .map(mapper::mapDTO)
                        .collect(Collectors.toList())
        );
    }

}