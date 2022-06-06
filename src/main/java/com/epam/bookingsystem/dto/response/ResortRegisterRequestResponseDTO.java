package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.enums.ResortRegisterStatus;

public class ResortRegisterRequestResponseDTO extends ResponseDTO {

    private ResortResponseDTO resortResponseDTO;

    private ResortRegisterStatus resortRegisterStatus;

    // List  messages

    public ResortResponseDTO getResortResponseDTO() {
        return resortResponseDTO;
    }

    public void setResortResponseDTO(ResortResponseDTO resortResponseDTO) {
        this.resortResponseDTO = resortResponseDTO;
    }

    public ResortRegisterStatus getResortRegisterStatus() {
        return resortRegisterStatus;
    }

    public void setResortRegisterStatus(ResortRegisterStatus resortRegisterStatus) {
        this.resortRegisterStatus = resortRegisterStatus;
    }
}
