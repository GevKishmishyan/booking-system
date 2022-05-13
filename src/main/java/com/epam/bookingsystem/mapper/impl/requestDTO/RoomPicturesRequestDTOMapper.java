package com.epam.bookingsystem.mapper.impl.requestDTO;

import com.epam.bookingsystem.dto.request.RoomPicturesRequestDTO;
import com.epam.bookingsystem.model.RoomPictures;

public class RoomPicturesRequestDTOMapper {

    public static RoomPictures RoomPicturesRequestDTOtoRoomPictures (RoomPicturesRequestDTO roomPicturesRequestDTO){
        RoomPictures roomPicture = new RoomPictures();
        roomPicture.setPicUrl(roomPicturesRequestDTO.getPicUrl());
        return roomPicture;
    }

}
