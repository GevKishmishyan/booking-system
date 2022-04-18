package com.epam.bookingsystem.model;


import com.epam.bookingsystem.model.enums.HotelType;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "resort")
public class Resort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @NotBlank
    private String name;
    @OneToOne
    private Address address;
    @Enumerated(EnumType.STRING)
    private HotelType type;
    @OneToOne
    private Tin tin;
    @Min(0)
    @Max(5)
    private Integer star;
    @OneToOne
    private Rate rate;
    @NotNull
    @Email
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String telephone;
    private String description;
    @OneToOne
    private ResortDetails resortDetails;
    @ManyToMany   //todo check relation
    private List<Room> rooms;
    @ManyToMany   //todo check relation
    private List<Review> reviews;

    public Resort(UUID id,
                  String name, Address address,
                  HotelType type, Tin tin,
                  Integer star, Rate rate, String email,
                  String telephone, String description,
                  ResortDetails resortDetails, List<Room> rooms,
                  List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.tin = tin;
        this.star = star;
        this.rate = rate;
        this.email = email;
        this.telephone = telephone;
        this.description = description;
        this.resortDetails = resortDetails;
        this.rooms = rooms;
        this.reviews = reviews;
    }

    public Resort() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public HotelType getType() {
        return type;
    }

    public void setType(HotelType type) {
        this.type = type;
    }

    public Tin getTin() {
        return tin;
    }

    public void setTin(Tin tin) {
        this.tin = tin;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
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

    public ResortDetails getResortDetails() {
        return resortDetails;
    }

    public void setResortDetails(ResortDetails resortDetails) {
        this.resortDetails = resortDetails;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resort resort = (Resort) o;
        return Objects.equals(id, resort.id) && Objects.equals(name, resort.name) && Objects.equals(address, resort.address) && type == resort.type && Objects.equals(tin, resort.tin) && Objects.equals(star, resort.star) && Objects.equals(rate, resort.rate) && Objects.equals(email, resort.email) && Objects.equals(telephone, resort.telephone) && Objects.equals(description, resort.description) && Objects.equals(resortDetails, resort.resortDetails) && Objects.equals(rooms, resort.rooms) && Objects.equals(reviews, resort.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, type, tin, star, rate, email, telephone, description, resortDetails, rooms, reviews);
    }

    @Override
    public String toString() {
        return "Resort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", type=" + type +
                ", tin=" + tin +
                ", star=" + star +
                ", rate=" + rate +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", description='" + description + '\'' +
                ", resortDetails=" + resortDetails +
                ", rooms=" + rooms +
                ", reviews=" + reviews +
                '}';
    }
}
