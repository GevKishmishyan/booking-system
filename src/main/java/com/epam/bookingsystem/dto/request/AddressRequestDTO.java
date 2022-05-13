package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;

public class AddressRequestDTO {
    @NotBlank
    private String country;
    @NotBlank
    private String region;
    @NotBlank
    private String section;
    @NotBlank
    private String address;

    public AddressRequestDTO(String country, String region,
                             String section, String address) {
        this.country = country;
        this.region = region;
        this.section = section;
        this.address = address;
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
