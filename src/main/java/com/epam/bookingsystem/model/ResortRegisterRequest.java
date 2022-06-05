package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RegisterStatus;

import javax.persistence.*;

@Entity
@Table(name = "resort_register_request")
public class ResortRegisterRequest extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    @Enumerated(EnumType.STRING)
    private RegisterStatus registerStatus = RegisterStatus.NEW;

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

    public RegisterStatus getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(RegisterStatus registerStatus) {
        this.registerStatus = registerStatus;
    }

    @Override
    public String toString() {
        return "ResortRegisterRequest{" +
                "resort=" + resort +
                ", registerStatus=" + registerStatus +
                ", id=" + id +
                '}';
    }
}
