package com.epam.bookingsystem.model;

import com.epam.bookingsystem.model.enums.ResortRegisterStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resort_register")
public class ResortRegister extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    @Enumerated(EnumType.STRING)
    private ResortRegisterStatus resortRegisterStatus = ResortRegisterStatus.NEW;

    @OneToMany
    @JoinColumn(name = "resort_register_id")
    private List<ResortRegisterComment> resortRegisterCommentList;

    private LocalDateTime createdAt = LocalDateTime.now();

    public ResortRegister() {
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public ResortRegisterStatus getResortRegisterStatus() {
        return resortRegisterStatus;
    }

    public void setResortRegisterStatus(ResortRegisterStatus resortRegisterStatus) {
        this.resortRegisterStatus = resortRegisterStatus;
    }

    public List<ResortRegisterComment> getResortRegisterCommentList() {
        return resortRegisterCommentList;
    }

    public void setResortRegisterCommentList(List<ResortRegisterComment> resortRegisterCommentList) {
        this.resortRegisterCommentList = resortRegisterCommentList;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ResortRegister{" +
                "resort=" + resort +
                ", resortRegisterStatus=" + resortRegisterStatus +
                ", resortRegisterCommentList=" + resortRegisterCommentList +
                '}';
    }
}
