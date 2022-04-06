package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.HotelType;

import java.util.List;
import java.util.UUID;

public class Hotel {

    private UUID id;
    private String name;
    private Address address;
    private HotelType type;
    private Tin tin;
    private Integer star;
    private Rate rate;
    private String email;
    private String phoneNumber; //todo: check this field
    private String description;
//    private HotelDetails hotelDetails; //todo: check this field

    private List<Room> rooms;
    private List<Review> reviews;

}
