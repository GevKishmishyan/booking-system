package com.epam.bookingsystem.dto.request;

public class ResortDetailsRequestDTO {
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
}
