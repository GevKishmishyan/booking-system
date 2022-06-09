package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResortNumberService {


    List<Room> addResortNumber(ResortRequestDTO resortRequestDTO, List<MultipartFile> files);
}
