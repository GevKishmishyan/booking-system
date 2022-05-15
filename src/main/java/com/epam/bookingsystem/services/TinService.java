package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.TinRequestDTO;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.Tin;

public interface TinService {
    Tin addTin(TinRequestDTO tinRequestDTO, Resort resort);
}
