package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "resort_details")
public class ResortDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private boolean airportShuttle;
    private boolean freeWiFi;
    private boolean bar;
    private boolean breakfast;
    private boolean teaCoffeeMaker;
    private boolean nonSmokingRooms;
    private boolean spaAndWellness;
    private boolean fitnessCenter;
    private boolean facilitiesForDisabledGuests;
    private boolean restaurant;
    private boolean privateParking;

    public ResortDetails(UUID id, boolean airportShuttle, boolean freeWiFi,
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
        return airportShuttle == that.airportShuttle && freeWiFi == that.freeWiFi && bar == that.bar && breakfast == that.breakfast && teaCoffeeMaker == that.teaCoffeeMaker && nonSmokingRooms == that.nonSmokingRooms && spaAndWellness == that.spaAndWellness && fitnessCenter == that.fitnessCenter && facilitiesForDisabledGuests == that.facilitiesForDisabledGuests && restaurant == that.restaurant && privateParking == that.privateParking && Objects.equals(id, that.id);
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
