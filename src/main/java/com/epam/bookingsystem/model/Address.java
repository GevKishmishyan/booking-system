package com.epam.bookingsystem.model;

import javax.persistence.*;
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
    @OneToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    public Address() {
    }

    public Address(long id, @NotBlank String country, @NotBlank String region, @NotBlank String section, @NotBlank String address, Resort resort) {
        super(id);
        this.country = country;
        this.region = region;
        this.section = section;
        this.address = address;
        this.resort = resort;
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

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return id == address1.id && Objects.equals(country, address1.country) && Objects.equals(region, address1.region) && Objects.equals(section, address1.section) && Objects.equals(address, address1.address) && Objects.equals(resort, address1.resort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, region, section, address, resort);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", section='" + section + '\'' +
                ", address='" + address + '\'' +
                ", resort=" + resort +
                '}';
    }
}