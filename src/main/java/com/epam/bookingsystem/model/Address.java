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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}