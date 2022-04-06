package com.epam.bookingsystem.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Booking {

    private UUID id;
    private LocalDate bookedFrom;
    private LocalDate bookedTo;
    private BigDecimal price;

}
