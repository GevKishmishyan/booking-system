package com.epam.bookingsystem.services;

import com.epam.bookingsystem.model.ResortRegisterRequest;

import java.util.List;

public interface ResortRegisterRequestService {

    List<ResortRegisterRequest> getAll();
    ResortRegisterRequest save(ResortRegisterRequest resortRegisterRequest);
}
