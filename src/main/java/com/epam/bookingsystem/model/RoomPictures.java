package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_pictures")
public class RoomPictures extends BaseEntity {
    @Column(name = "picture_url")
    private String picUrl;

    public RoomPictures(long id, String picUrl) {
        super(id);
        this.picUrl = picUrl;
    }

    public RoomPictures() {
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
        RoomPictures that = (RoomPictures) o;
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
