package com.epam.bookingsystem.services;


import com.epam.bookingsystem.model.RoomPicture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RoomPictureService {

    List<RoomPicture> addPictures(List<MultipartFile> files);
}
