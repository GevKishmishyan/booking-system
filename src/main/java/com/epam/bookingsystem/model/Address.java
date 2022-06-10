package com.epam.bookingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


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

    public Address(long id,  String country, String region, String section, String address) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(country, address1.country) && Objects.equals(region, address1.region) && Objects.equals(section, address1.section) && Objects.equals(address, address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, section, address);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", section='" + section + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}