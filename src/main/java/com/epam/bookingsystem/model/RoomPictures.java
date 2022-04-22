package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_pictures")
public class RoomPictures extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "picture_url")
    private String picUrl;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resort_number_id")
    private ResortNumber resortNumber;

    public RoomPictures() {
    }

    public RoomPictures(long id, String picUrl, ResortNumber resortNumber) {
        this.id = id;
        this.picUrl = picUrl;
        this.resortNumber = resortNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public ResortNumber getResortNumber() {
        return resortNumber;
    }

    public void setResortNumber(ResortNumber resortNumber) {
        this.resortNumber = resortNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomPictures that = (RoomPictures) o;
        return id == that.id && Objects.equals(picUrl, that.picUrl) && Objects.equals(resortNumber, that.resortNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picUrl, resortNumber);
    }

    @Override
    public String toString() {
        return "RoomPictures{" +
                "id=" + id +
                ", picUrl='" + picUrl + '\'' +
                ", resortNumber=" + resortNumber +
                '}';
    }
}
