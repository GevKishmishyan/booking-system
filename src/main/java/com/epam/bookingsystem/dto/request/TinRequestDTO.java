package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;

public class TinRequestDTO {
    @NotBlank
    private String serialNumber;
    @NotBlank
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
