package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ResortNumberRequestDTO;
import com.epam.bookingsystem.model.ResortNumber;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResortNumberService {


    List<ResortNumber> addResortNumber(List<ResortNumberRequestDTO> resortNumberRequestDTOList, List<MultipartFile> standard, List<MultipartFile> lux);
}
