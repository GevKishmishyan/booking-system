package com.epam.bookingsystem.dto.request;

import com.epam.bookingsystem.model.enums.ResortType;

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
    private String description;
    @NotNull
    private AddressRequestDTO addressRequestDTO;
    @NotNull
    private ResortDetailsRequestDTO resortDetailsRequestDTO;
    @NotNull
    private TinRequestDTO tinRequestDTO;
    @NotNull
    private List<ResortNumberRequestDTO> resortNumberRequestDTOList;

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

    public TinRequestDTO getTinRequestDTO() {
        return tinRequestDTO;
    }

    public void setTinRequestDTO(TinRequestDTO tinRequestDTO) {
        this.tinRequestDTO = tinRequestDTO;
    }

    public List<ResortNumberRequestDTO> getResortNumberRequestDTOList() {
        return resortNumberRequestDTOList;
    }

    public void setResortNumberRequestDTOList(List<ResortNumberRequestDTO> resortNumberRequestDTOList) {
        this.resortNumberRequestDTOList = resortNumberRequestDTOList;
    }


    @Override
    public String toString() {
        return "ResortRequestDTO{" +
                "name='" + name + '\'' +
                ", resortType=" + resortType +
                ", star=" + star +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", description='" + description + '\'' +
                ", addressRequestDTO=" + addressRequestDTO +
                ", resortDetailsRequestDTO=" + resortDetailsRequestDTO +
                ", tinRequestDTO=" + tinRequestDTO +
                ", resortNumberRequestDTOList=" + resortNumberRequestDTOList +
                '}';
    }
}
