package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RoomType;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class HotelRoom {

    private UUID id;
    private RoomType type;
    private List<String> pictures;
    private RoomDetails roomDetails;
    private Integer availableCount;
    private BigDecimal price; //todo: price for 1 day for specific RoomType;

}
