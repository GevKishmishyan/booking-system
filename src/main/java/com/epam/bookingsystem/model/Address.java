package com.epam.bookingsystem.model;

import java.util.UUID;

public class Address {

    private UUID id;
    private String country;
    private String region;
    private String section; //todo: check this field [name] (residence,district,abode,section)
    private String address;

}
