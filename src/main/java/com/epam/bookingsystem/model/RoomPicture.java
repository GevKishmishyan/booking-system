package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_picture")
public class RoomPicture extends BaseEntity {
    @Column(name = "picture_url")
    private String picUrl;

    public RoomPicture(String picUrl) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomPicture that = (RoomPicture) o;
        return Objects.equals(picUrl, that.picUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(picUrl);
    }

    @Override
    public String toString() {
        return "RoomPictures{" +
                "picUrl='" + picUrl + '\'' +
                '}';
    }
}
