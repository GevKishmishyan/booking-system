package com.epam.bookingsystem.dto.request;

import javax.persistence.Column;

public class RoomDetailsRequestDTO extends RequestDto{
    private boolean airConditioner;
    private boolean television;
    private boolean sofa;
    private boolean teaTable;
    private boolean shower;
    private boolean bathtub;
    private boolean bathAccessories;
    private boolean hairdryer;
    private boolean minibar;
    private boolean fridge;
    private boolean dishes;
    private boolean electricKettle;

    public boolean isAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public boolean isTelevision() {
        return television;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }

    public boolean isSofa() {
        return sofa;
    }

    public void setSofa(boolean sofa) {
        this.sofa = sofa;
    }

    public boolean isTeaTable() {
        return teaTable;
    }

    public void setTeaTable(boolean teaTable) {
        this.teaTable = teaTable;
    }

    public boolean isShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }

    public boolean isBathtub() {
        return bathtub;
    }

    public void setBathtub(boolean bathtub) {
        this.bathtub = bathtub;
    }

    public boolean isBathAccessories() {
        return bathAccessories;
    }

    public void setBathAccessories(boolean bathAccessories) {
        this.bathAccessories = bathAccessories;
    }

    public boolean isHairdryer() {
        return hairdryer;
    }

    public void setHairdryer(boolean hairdryer) {
        this.hairdryer = hairdryer;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public boolean isDishes() {
        return dishes;
    }

    public void setDishes(boolean dishes) {
        this.dishes = dishes;
    }

    public boolean isElectricKettle() {
        return electricKettle;
    }

    public void setElectricKettle(boolean electricKettle) {
        this.electricKettle = electricKettle;
    }
}
