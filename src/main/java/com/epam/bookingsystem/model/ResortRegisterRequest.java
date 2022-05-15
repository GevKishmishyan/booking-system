package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.RequestStatus;

import javax.persistence.*;

@Entity
@Table(name = "resort_register_request")
public class ResortRegisterRequest extends BaseEntity{

    private String comment;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    @OneToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    public ResortRegisterRequest(String comment, RequestStatus requestStatus, Resort resort) {
        this.comment = comment;
        this.requestStatus = requestStatus;
        this.resort = resort;
    }

    public ResortRegisterRequest() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }
}
