package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.enums.ResortType;

import java.util.List;

public class ResortResponseDTO extends ResponseDTO {

    private String name;

    private ResortType resortType;

    private Integer star;

    private String email;

    private String telephone;

    private String description;

    private boolean active;

    private AddressResponseDTO addressResponseDTO;

    private RateResponseDTO rateResponseDTO;

    private ResortDetailsResponseDTO resortDetailsResponseDTO;

    private List<ResortNumberResponseDTO> resortNumberResponseDTOList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AddressResponseDTO getAddressResponseDTO() {
        return addressResponseDTO;
    }

    public void setAddressResponseDTO(AddressResponseDTO addressResponseDTO) {
        this.addressResponseDTO = addressResponseDTO;
    }

    public RateResponseDTO getRateResponseDTO() {
        return rateResponseDTO;
    }

    public void setRateResponseDTO(RateResponseDTO rateResponseDTO) {
        this.rateResponseDTO = rateResponseDTO;
    }

    public ResortDetailsResponseDTO getResortDetailsResponseDTO() {
        return resortDetailsResponseDTO;
    }

    public void setResortDetailsResponseDTO(ResortDetailsResponseDTO resortDetailsResponseDTO) {
        this.resortDetailsResponseDTO = resortDetailsResponseDTO;
    }

    public List<ResortNumberResponseDTO> getResortNumberResponseDTOList() {
        return resortNumberResponseDTOList;
    }

    public void setResortNumberResponseDTOList(List<ResortNumberResponseDTO> resortNumberResponseDTOList) {
        this.resortNumberResponseDTOList = resortNumberResponseDTOList;
    }

    public TinResponseDTO getTinResponseDTO() {
        return tinResponseDTO;
    }

    public void setTinResponseDTO(TinResponseDTO tinResponseDTO) {
        this.tinResponseDTO = tinResponseDTO;
    }
}
