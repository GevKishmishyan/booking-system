package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.HotelType;

import java.util.List;
import java.util.UUID;

public class Resort {
    private UUID id;
    private String name;
    private Address address;
    private HotelType type;
    private Tin tin;
    private Integer star;
    private Rate rate;
    private String email;
    private String telephone; //todo: check this field
    private String description;
//    private ResortDetails resortDetails; //todo: check this field

    private List<Room> rooms;
    private List<Review> reviews;

}
