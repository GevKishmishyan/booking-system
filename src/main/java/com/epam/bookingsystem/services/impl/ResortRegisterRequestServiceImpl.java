package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.dto.response.ResortRegisterRequestResponseDTO;
import com.epam.bookingsystem.mapper.impl.MyMapperForAll;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import com.epam.bookingsystem.repository.ResortRegisterRequestRepository;
import com.epam.bookingsystem.services.ResortRegisterRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResortRegisterRequestServiceImpl implements ResortRegisterRequestService {

    final
    ResortRegisterRequestRepository resortRegisterRequestRepository;

    public ResortRegisterRequestServiceImpl(ResortRegisterRequestRepository resortRegisterRequestRepository) {
        this.resortRegisterRequestRepository = resortRegisterRequestRepository;
    }

    @Override
    public List<ResortRegisterRequestResponseDTO> getAll() {
        List<ResortRegisterRequest> requestList = resortRegisterRequestRepository.findAll();
        return MyMapperForAll.resortRegisterRequestList_To_responseDTOList(requestList);
    }

}
