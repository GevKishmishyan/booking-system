package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import com.epam.bookingsystem.model.enums.RequestStatus;
import com.epam.bookingsystem.repository.ResortRegisterRequestRepository;
import com.epam.bookingsystem.services.ResortRegisterRequestService;
import org.springframework.stereotype.Service;

@Service
public class ResortRegisterRequestServiceImpl implements ResortRegisterRequestService {
    private final ResortRegisterRequestRepository resortRegisterRequestRepository;

    public ResortRegisterRequestServiceImpl(ResortRegisterRequestRepository resortRegisterRequestRepository) {
        this.resortRegisterRequestRepository = resortRegisterRequestRepository;
    }

    @Override
    public ResortRegisterRequest addResortRegisterRequest( Resort resort) {
        ResortRegisterRequest resortRegisterRequest = new ResortRegisterRequest("",RequestStatus.NEW,resort);
        resortRegisterRequestRepository.save(resortRegisterRequest);
        return null;
    }
}
