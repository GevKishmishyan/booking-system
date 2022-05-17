package com.epam.bookingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @NotBlank
    private String country;
    @NotBlank
    private String region;
    @NotBlank
    private String section;
    @NotBlank
    private String address;

    public Address(long id, @NotBlank String country, @NotBlank String region, @NotBlank String section, @NotBlank String address) {
        super(id);
        this.country = country;
        this.region = region;
        this.section = section;
        this.address = address;
    }

    public Address() {
    }
}