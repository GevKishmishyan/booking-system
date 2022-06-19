package com.epam.bookingsystem.services.impl;

import com.epam.bookingsystem.model.RoomPicture;
import com.epam.bookingsystem.repository.RoomPictureRepository;
import com.epam.bookingsystem.services.RoomPictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomPictureServiceImpl implements RoomPictureService {
    private final RoomPictureRepository roomPictureRepository;

    @Value("${path.uploadPicturePath}")
    private String uploadPicturePath;


    public RoomPictureServiceImpl(RoomPictureRepository roomPictureRepository) {
        this.roomPictureRepository = roomPictureRepository;
    }


    @Override
    public List<RoomPicture> addPictures(List<MultipartFile> files) {

        List<RoomPicture> roomPictures = new ArrayList<>();

        for (MultipartFile multipartFile : files) {
            if (!multipartFile.isEmpty()) {
                String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
                String filePath = uploadPicturePath + File.separator + fileName;
                File file = new File(filePath);
                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                roomPictures.add(new RoomPicture(filePath));
            }
        }
        roomPictureRepository.saveAll(roomPictures);
        return roomPictures;
    }
}
