package com.epam.bookingsystem.dto.response;

import com.epam.bookingsystem.model.enums.RegisterStatus;

public class ResortRegisterRequestResponseDTO {

    private ResortResponseDTO resortResponseDTO;

    private RegisterStatus requestStatus;

    // List  messages

    public ResortResponseDTO getResortResponseDTO() {
        return resortResponseDTO;
    }

    public void setResortResponseDTO(ResortResponseDTO resortResponseDTO) {
        this.resortResponseDTO = resortResponseDTO;
    }

    public RegisterStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RegisterStatus requestStatus) {
        System.out.println(" setRequestStatus(RegisterStatus requestStatus)");
        this.requestStatus = requestStatus;
    }
}
