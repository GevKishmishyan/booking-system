package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "resort_details")
public class ResortDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "airport_shuttle")
    private boolean airportShuttle;
    @Column(name = "free_Wi_Fi")
    private boolean freeWiFi;
    private boolean bar;
    private boolean breakfast;
    @Column(name = "tea_coffee_maker")
    private boolean teaCoffeeMaker;
    @Column(name = "non_smoking_rooms")
    private boolean nonSmokingRooms;
    @Column(name = "spa_and_wellness")
    private boolean spaAndWellness;
    @Column(name = "fitness_center")
    private boolean fitnessCenter;
    @Column(name = "facilities_for_disable_guests")
    private boolean facilitiesForDisabledGuests;
    private boolean restaurant;
    @Column(name = "private_parking")
    private boolean privateParking;

    public ResortDetails(long id, boolean airportShuttle, boolean freeWiFi,
                         boolean bar, boolean breakfast, boolean teaCoffeeMaker,
                         boolean nonSmokingRooms, boolean spaAndWellness,
                         boolean fitnessCenter, boolean facilitiesForDisabledGuests,
                         boolean restaurant, boolean privateParking) {
        this.id = id;
        this.airportShuttle = airportShuttle;
        this.freeWiFi = freeWiFi;
        this.bar = bar;
        this.breakfast = breakfast;
        this.teaCoffeeMaker = teaCoffeeMaker;
        this.nonSmokingRooms = nonSmokingRooms;
        this.spaAndWellness = spaAndWellness;
        this.fitnessCenter = fitnessCenter;
        this.facilitiesForDisabledGuests = facilitiesForDisabledGuests;
        this.restaurant = restaurant;
        this.privateParking = privateParking;
    }

    public ResortDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAirportShuttle() {
        return airportShuttle;
    }

    public void setAirportShuttle(boolean airportShuttle) {
        this.airportShuttle = airportShuttle;
    }

    public boolean isFreeWiFi() {
        return freeWiFi;
    }

    public void setFreeWiFi(boolean freeWiFi) {
        this.freeWiFi = freeWiFi;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isTeaCoffeeMaker() {
        return teaCoffeeMaker;
    }

    public void setTeaCoffeeMaker(boolean teaCoffeeMaker) {
        this.teaCoffeeMaker = teaCoffeeMaker;
    }

    public boolean isNonSmokingRooms() {
        return nonSmokingRooms;
    }

    public void setNonSmokingRooms(boolean nonSmokingRooms) {
        this.nonSmokingRooms = nonSmokingRooms;
    }

    public boolean isSpaAndWellness() {
        return spaAndWellness;
    }

    public void setSpaAndWellness(boolean spaAndWellness) {
        this.spaAndWellness = spaAndWellness;
    }

    public boolean isFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(boolean fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public boolean isFacilitiesForDisabledGuests() {
        return facilitiesForDisabledGuests;
    }

    public void setFacilitiesForDisabledGuests(boolean facilitiesForDisabledGuests) {
        this.facilitiesForDisabledGuests = facilitiesForDisabledGuests;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isPrivateParking() {
        return privateParking;
    }

    public void setPrivateParking(boolean privateParking) {
        this.privateParking = privateParking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResortDetails that = (ResortDetails) o;
        return id == that.id && airportShuttle == that.airportShuttle && freeWiFi == that.freeWiFi && bar == that.bar && breakfast == that.breakfast && teaCoffeeMaker == that.teaCoffeeMaker && nonSmokingRooms == that.nonSmokingRooms && spaAndWellness == that.spaAndWellness && fitnessCenter == that.fitnessCenter && facilitiesForDisabledGuests == that.facilitiesForDisabledGuests && restaurant == that.restaurant && privateParking == that.privateParking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airportShuttle, freeWiFi, bar, breakfast, teaCoffeeMaker, nonSmokingRooms, spaAndWellness, fitnessCenter, facilitiesForDisabledGuests, restaurant, privateParking);
    }

    @Override
    public String toString() {
        return "ResortDetails{" +
                "id=" + id +
                ", airportShuttle=" + airportShuttle +
                ", freeWiFi=" + freeWiFi +
                ", bar=" + bar +
                ", breakfast=" + breakfast +
                ", teaCoffeeMaker=" + teaCoffeeMaker +
                ", nonSmokingRooms=" + nonSmokingRooms +
                ", spaAndWellness=" + spaAndWellness +
                ", fitnessCenter=" + fitnessCenter +
                ", facilitiesForDisabledGuests=" + facilitiesForDisabledGuests +
                ", restaurant=" + restaurant +
                ", privateParking=" + privateParking +
                '}';
    }
}
