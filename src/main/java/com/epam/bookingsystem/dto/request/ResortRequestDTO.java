package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.model.enums.ResortType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

public class ResortRequestDTO {
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

    AddressRequestDTO addressRequestDTO;
    ResortDetailsRequestDTO resortDetailsRequestDTO;
    ResortNumberRequestDTO resortNumberRequestDTO;
    RoomDetailsRequestDTO roomDetailsRequestDTO;
    RoomPicturesRequestDTO roomPicturesRequestDTO;
    RoomRequestDTO roomRequestDTO;
    TinRequestDTO tinRequestDTO;

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

    public AddressRequestDTO getAddressRequestDTO() {
        return addressRequestDTO;
    }

    public void setAddressRequestDTO(AddressRequestDTO addressRequestDTO) {
        this.addressRequestDTO = addressRequestDTO;
    }

    public ResortDetailsRequestDTO getResortDetailsRequestDTO() {
        return resortDetailsRequestDTO;
    }

    public void setResortDetailsRequestDTO(ResortDetailsRequestDTO resortDetailsRequestDTO) {
        this.resortDetailsRequestDTO = resortDetailsRequestDTO;
    }

    public ResortNumberRequestDTO getResortNumberRequestDTO() {
        return resortNumberRequestDTO;
    }

    public void setResortNumberRequestDTO(ResortNumberRequestDTO resortNumberRequestDTO) {
        this.resortNumberRequestDTO = resortNumberRequestDTO;
    }

    public RoomDetailsRequestDTO getRoomDetailsRequestDTO() {
        return roomDetailsRequestDTO;
    }

    public void setRoomDetailsRequestDTO(RoomDetailsRequestDTO roomDetailsRequestDTO) {
        this.roomDetailsRequestDTO = roomDetailsRequestDTO;
    }

    public RoomPicturesRequestDTO getRoomPicturesRequestDTO() {
        return roomPicturesRequestDTO;
    }

    public void setRoomPicturesRequestDTO(RoomPicturesRequestDTO roomPicturesRequestDTO) {
        this.roomPicturesRequestDTO = roomPicturesRequestDTO;
    }

    public RoomRequestDTO getRoomRequestDTO() {
        return roomRequestDTO;
    }

    public void setRoomRequestDTO(RoomRequestDTO roomRequestDTO) {
        this.roomRequestDTO = roomRequestDTO;
    }

    public TinRequestDTO getTinRequestDTO() {
        return tinRequestDTO;
    }

    public void setTinRequestDTO(TinRequestDTO tinRequestDTO) {
        this.tinRequestDTO = tinRequestDTO;
    }
}
