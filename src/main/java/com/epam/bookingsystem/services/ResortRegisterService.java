package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ResortRegisterCommentRequestDTO;
import com.epam.bookingsystem.dto.request.ResortRegisterRequestDTO;
import com.epam.bookingsystem.model.ResortRegister;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResortRegisterService {

    ResortRegister addNewResortRegisterRequest(ResortRegisterRequestDTO resortRegisterRequestDTO, List<MultipartFile> standard, List<MultipartFile> lux);

    List<ResortRegister> getAll(int page, int size);

    ResortRegister addComment(ResortRegisterCommentRequestDTO resortRegisterCommentRequestDTO);

    ResortRegister conformRegistration(Long resortRegisterId);
}
