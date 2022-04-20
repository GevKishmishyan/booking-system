package com.epam.bookingsystem.model;

import javax.persistence.*;
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double rate;
    private String comment;

}
