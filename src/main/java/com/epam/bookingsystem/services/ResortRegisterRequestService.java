package com.epam.bookingsystem.services;

import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortRegisterRequest;

public interface ResortRegisterRequestService {
    ResortRegisterRequest  addResortRegisterRequest(Resort resort);
}
