package com.epam.bookingsystem.dto.request;

public class RoomPictureRequestDTO extends RequestDto{

    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
