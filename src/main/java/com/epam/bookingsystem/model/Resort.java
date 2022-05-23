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
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String telephone;
    @OneToOne
    @JoinColumn(name = "id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "id")
    private Rate rate;
    @OneToOne
    @JoinColumn(name = "id")
    private ResortDetails resortDetails;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Room> room;
    @OneToOne
    @JoinColumn(name = "id")
    private Tin tin;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Review> review;

    private boolean isActive;

    public Resort(long id, @NotBlank String name, ResortType resortType, @Min(1) @Max(5) Integer star,
                  @NotNull @Email String email, @Pattern(regexp = "(^$|[0-9]{10})") String telephone,
                  Address address, Rate rate, ResortDetails resortDetails, List<Room> room,
                  Tin tin, List<Review> review) {
        super(id);
        this.name = name;
        this.resortType = resortType;
        this.star = star;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.rate = rate;
        this.resortDetails = resortDetails;
        this.room = room;
        this.tin = tin;
        this.review = review;
    }

    public Resort() {
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

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public Tin getTin() {
        return tin;
    }

    public void setTin(Tin tin) {
        this.tin = tin;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resort resort = (Resort) o;
        return Objects.equals(name, resort.name) && resortType == resort.resortType && Objects.equals(star, resort.star) && Objects.equals(email, resort.email) && Objects.equals(telephone, resort.telephone) && Objects.equals(address, resort.address) && Objects.equals(rate, resort.rate) && Objects.equals(resortDetails, resort.resortDetails) && Objects.equals(room, resort.room) && Objects.equals(tin, resort.tin) && Objects.equals(review, resort.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, resortType, star, email, telephone, address, rate, resortDetails, room, tin, review);
    }

    @Override
    public String toString() {
        return "Resort{" +
                "name='" + name + '\'' +
                ", resortType=" + resortType +
                ", star=" + star +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address=" + address +
                ", rate=" + rate +
                ", resortDetails=" + resortDetails +
                ", room=" + room +
                ", tin=" + tin +
                ", review=" + review +
                '}';
    }
}
