package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.TinRequestDTO;
import com.epam.bookingsystem.model.Tin;

public class TinRequestDTOMapper {

    public static Tin tinRequestDTOtoTin (TinRequestDTO tinRequestDTO){
        Tin tin = new Tin();
        tin.setSerialNumber(tinRequestDTO.getSerialNumber());
        tin.setDocument(tinRequestDTO.getDocument());
        return tin;
    }

}
