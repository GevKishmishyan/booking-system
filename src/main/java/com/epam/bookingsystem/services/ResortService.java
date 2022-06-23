package com.epam.bookingsystem.services;


import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.model.Resort;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResortService {
    Resort addResort(ResortRequestDTO resortRequestDTO, List<MultipartFile> standard, List<MultipartFile> lux);

    boolean conformRegistration(Resort resort);
}
