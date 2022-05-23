package com.epam.bookingsystem.dto.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TinResponseDTO {

    private String serialNumber;
    private String document;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
