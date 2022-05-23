package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.*;
import com.epam.bookingsystem.model.enums.ResortType;

import java.util.List;

public class ResortResponseDTO {

    private String name;

    private ResortType resortType;

    private Integer star;

    private String email;

    private String telephone;

    private AddressResponseDTO addressResponseDTO;

    private ResortDetailsResponseDTO resortDetailsResponseDTO;

    private List<RoomResponseDTO> rooms;

    private TinResponseDTO tinResponseDTO;

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

    public AddressResponseDTO getAddressResponseDTO() {
        return addressResponseDTO;
    }

    public void setAddressResponseDTO(AddressResponseDTO addressResponseDTO) {
        this.addressResponseDTO = addressResponseDTO;
    }

    public ResortDetailsResponseDTO getResortDetailsResponseDTO() {
        return resortDetailsResponseDTO;
    }

    public void setResortDetailsResponseDTO(ResortDetailsResponseDTO resortDetailsResponseDTO) {
        this.resortDetailsResponseDTO = resortDetailsResponseDTO;
    }

    public List<RoomResponseDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomResponseDTO> rooms) {
        this.rooms = rooms;
    }

    public TinResponseDTO getTinResponseDTO() {
        return tinResponseDTO;
    }

    public void setTinResponseDTO(TinResponseDTO tinResponseDTO) {
        this.tinResponseDTO = tinResponseDTO;
    }
}
