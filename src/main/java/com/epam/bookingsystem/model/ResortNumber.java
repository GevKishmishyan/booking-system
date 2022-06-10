package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RoomType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "resort_number")
public class ResortNumber extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @NotNull
    private BigDecimal perNightPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_details_id", referencedColumnName = "id")
    private RoomDetails roomDetails;
    @OneToMany
    @JoinColumn(name = "resort_number_id")
    private List<Room> rooms;
    @OneToMany
    @JoinColumn(name = "resort_number_id")
    private List<RoomPicture> roomPictures;

    public ResortNumber(long id, RoomType roomType, BigDecimal perNightPrice, RoomDetails roomDetails, List<Room> rooms, List<RoomPicture> roomPictures) {
        super(id);
        this.roomType = roomType;
        this.perNightPrice = perNightPrice;
        this.roomDetails = roomDetails;
        this.rooms = rooms;
        this.roomPictures = roomPictures;
    }

    public ResortNumber() {

    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPerNightPrice() {
        return perNightPrice;
    }

    public void setPerNightPrice(BigDecimal perNightPrice) {
        this.perNightPrice = perNightPrice;
    }

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<RoomPicture> getRoomPictures() {
        return roomPictures;
    }

    public void setRoomPictures(List<RoomPicture> roomPictures) {
        this.roomPictures = roomPictures;
    }
}
