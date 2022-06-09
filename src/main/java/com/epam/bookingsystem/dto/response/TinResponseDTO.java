package com.epam.bookingsystem.dto.response;

public class TinResponseDTO extends ResponseDTO {
    private String serialNumber;
    private String document;
    public TinResponseDTO() {
    }
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

