package com.epam.bookingsystem.services;

import com.epam.bookingsystem.dto.request.ResortRequestDTO;
import com.epam.bookingsystem.dto.request.RoomPicturesRequestDTO;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.RoomPictures;

public interface RoomPicturesService {
    RoomPictures addRoomPictures(RoomPicturesRequestDTO roomPicturesRequestDTO, ResortNumber resortNumber);
}
