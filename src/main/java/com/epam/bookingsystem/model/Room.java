package com.epam.bookingsystem.model;

import java.util.List;
import java.util.UUID;

public class Room {

    private UUID id;
    private Integer roomNumber;
    private HotelRoom hotelRoom; //todo: check this field;

    private List<Booking> bookings;

}
