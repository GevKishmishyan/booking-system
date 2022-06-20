package com.epam.bookingsystem.model;


import com.epam.bookingsystem.model.enums.ResortType;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "resort")
public class Resort extends BaseEntity {

    @NotBlank
    private String name;
    @Enumerated(EnumType.STRING)
    private ResortType resortType;
    @Min(1)
    @Max(5)
    private Integer star;
    @NotNull
    @Email
    private String email;
    //    @Pattern(regexp = "(^$|[0-9]{10})")
    private String telephone;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    private boolean active = false;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id", referencedColumnName = "id")
    private Rate rate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resort_details_id", referencedColumnName = "id")
    private ResortDetails resortDetails;
    @OneToMany
    @JoinColumn(name = "resort_id")
    private List<ResortNumber> resortNumbers;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tin_id", referencedColumnName = "id")
    private Tin tin;
    @OneToMany
    @JoinColumn(name = "resort_id")
    private List<Review> reviews;

    public Resort() {
    }

    public Resort(long id, String name, ResortType resortType, Integer star, String email, String telephone, String description, boolean active, Address address, Rate rate, ResortDetails resortDetails, List<ResortNumber> resortNumbers, Tin tin, List<Review> reviews) {
        super(id);
        this.name = name;
        this.resortType = resortType;
        this.star = star;
        this.email = email;
        this.telephone = telephone;
        this.description = description;
        this.active = active;
        this.address = address;
        this.rate = rate;
        this.resortDetails = resortDetails;
        this.resortNumbers = resortNumbers;
        this.tin = tin;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResortType getResortType() {
        return resortType;
    }

    public void setResortType(ResortType resortType) {
        this.resortType = resortType;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public ResortDetails getResortDetails() {
        return resortDetails;
    }

    public void setResortDetails(ResortDetails resortDetails) {
        this.resortDetails = resortDetails;
    }

    public List<ResortNumber> getResortNumbers() {
        return resortNumbers;
    }

    public void setResortNumbers(List<ResortNumber> resortNumbers) {
        this.resortNumbers = resortNumbers;
    }

    public Tin getTin() {
        return tin;
    }

    public void setTin(Tin tin) {
        this.tin = tin;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
