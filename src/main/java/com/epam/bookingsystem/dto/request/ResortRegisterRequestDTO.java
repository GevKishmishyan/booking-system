package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotNull;

public class ResortRegisterRequestDTO extends RequestDto {

    @NotNull
    private ResortRequestDTO resortRequestDTO;

    public ResortRegisterRequestDTO() {
    }

    public ResortRequestDTO getResortRequestDTO() {
        return resortRequestDTO;
    }

    public void setResortRequestDTO(ResortRequestDTO resortRequestDTO) {
        this.resortRequestDTO = resortRequestDTO;
    }

    @Override
    public String toString() {
        return "ResortRegisterRequestDTO{" +
                "resortRequestDTO=" + resortRequestDTO +
                '}';
    }
}
