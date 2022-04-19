package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_details")
public class RoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "air_conditioner")
    private boolean airConditioner;
    private boolean television;
    private boolean sofa;
    @Column(name = "tea_table")
    private boolean teaTable;
    private boolean shower;
    private boolean bathtub;
    @Column(name = "bath_accessories")
    private boolean bathAccessories;
    private boolean hairdryer;
    private boolean minibar;
    private boolean fridge;
    private boolean dishes;
    @Column(name = "electric_kettle")
    private boolean electricKettle;

    public RoomDetails(long id, boolean airConditioner, boolean television,
                       boolean sofa, boolean teaTable, boolean shower,
                       boolean bathtub, boolean bathAccessories,
                       boolean hairdryer, boolean minibar,
                       boolean fridge, boolean dishes,
                       boolean electricKettle) {
        this.id = id;
        this.airConditioner = airConditioner;
        this.television = television;
        this.sofa = sofa;
        this.teaTable = teaTable;
        this.shower = shower;
        this.bathtub = bathtub;
        this.bathAccessories = bathAccessories;
        this.hairdryer = hairdryer;
        this.minibar = minibar;
        this.fridge = fridge;
        this.dishes = dishes;
        this.electricKettle = electricKettle;
    }

    public RoomDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDetails that = (RoomDetails) o;
        return airConditioner == that.airConditioner && television == that.television && sofa == that.sofa && teaTable == that.teaTable && shower == that.shower && bathtub == that.bathtub && bathAccessories == that.bathAccessories && hairdryer == that.hairdryer && minibar == that.minibar && fridge == that.fridge && dishes == that.dishes && electricKettle == that.electricKettle && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airConditioner, television, sofa, teaTable, shower, bathtub, bathAccessories, hairdryer, minibar, fridge, dishes, electricKettle);
    }

    @Override
    public String toString() {
        return "RoomDetails{" +
                "id=" + id +
                ", airConditioner=" + airConditioner +
                ", television=" + television +
                ", sofa=" + sofa +
                ", teaTable=" + teaTable +
                ", shower=" + shower +
                ", bathtub=" + bathtub +
                ", bathAccessories=" + bathAccessories +
                ", hairdryer=" + hairdryer +
                ", minibar=" + minibar +
                ", fridge=" + fridge +
                ", dishes=" + dishes +
                ", electricKettle=" + electricKettle +
                '}';
    }
}
