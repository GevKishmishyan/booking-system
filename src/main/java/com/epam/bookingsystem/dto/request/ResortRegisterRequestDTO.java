package com.epam.bookingsystem.dto.request;

public class ResortRegisterRequestDTO extends RequestDto {

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
