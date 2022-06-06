package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.ResortRegisterStatus;

import javax.persistence.*;

@Entity
@Table(name = "resort_register_request")
public class ResortRegisterRequest extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    @Enumerated(EnumType.STRING)
    private ResortRegisterStatus resortRegisterStatus = ResortRegisterStatus.NEW;

    // List comments


    public ResortRegisterRequest() {
    }

    public ResortRegisterRequest(Resort resort) {
        this.resort = resort;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public ResortRegisterStatus getRegisterStatus() {
        return resortRegisterStatus;
    }

    public void setRegisterStatus(ResortRegisterStatus resortRegisterStatus) {
        this.resortRegisterStatus = resortRegisterStatus;
    }

    @Override
    public String toString() {
        return "ResortRegisterRequest{" +
                "resort=" + resort +
                ", resortRegisterStatus=" + resortRegisterStatus +
                ", id=" + id +
                '}';
    }
}
