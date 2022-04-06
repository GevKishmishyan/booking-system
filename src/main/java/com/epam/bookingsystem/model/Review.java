package com.epam.bookingsystem.model;

import javax.persistence.OneToOne;
import java.util.UUID;

public class Review {

    private UUID id;
    private UUID bookingId;
    private Double rate;
    private String comment;

}
