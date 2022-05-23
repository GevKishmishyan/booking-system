package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_picture")
public class RoomPicture extends BaseEntity {
    @Column(name = "picture_url")
    private String picUrl;

    public RoomPicture(long id, String picUrl) {
        super(id);
        this.picUrl = picUrl;
    }

    public RoomPicture() {
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

}
