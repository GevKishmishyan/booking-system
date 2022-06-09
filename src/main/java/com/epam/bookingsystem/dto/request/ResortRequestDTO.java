package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.model.Address;
import com.epam.bookingsystem.model.ResortDetails;
import com.epam.bookingsystem.model.Tin;
import com.epam.bookingsystem.model.enums.ResortType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.util.List;

public class ResortRequestDTO extends RequestDto {
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
    //    @Pattern(regexp = "(^$|[0-9]{10})")
    private String telephone;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private Address address;
    private ResortDetails resortDetails;
    private Tin tin;

    List<RoomRequestDTO> roomListRequestDTO;
    ResortNumberRequestDTO resortNumberRequestDTO;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ResortDetails getResortDetails() {
        return resortDetails;
    }

    public void setResortDetails(ResortDetails resortDetails) {
        this.resortDetails = resortDetails;
    }

    public Tin getTin() {
        return tin;
    }

    public void setTin(Tin tin) {
        this.tin = tin;
    }

    public List<RoomRequestDTO> getRoomListRequestDTO() {
        return roomListRequestDTO;
    }

    public void setRoomListRequestDTO(List<RoomRequestDTO> roomListRequestDTO) {
        this.roomListRequestDTO = roomListRequestDTO;
    }

    public ResortNumberRequestDTO getResortNumberRequestDTO() {
        return resortNumberRequestDTO;
    }

    public void setResortNumberRequestDTO(ResortNumberRequestDTO resortNumberRequestDTO) {
        this.resortNumberRequestDTO = resortNumberRequestDTO;
    }
}
