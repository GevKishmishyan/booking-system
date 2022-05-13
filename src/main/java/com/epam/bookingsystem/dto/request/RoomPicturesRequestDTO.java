package com.epam.bookingsystem.dto.request;

import javax.persistence.Column;

public class RoomPicturesRequestDTO {
    @Column(name = "picture_url")
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
