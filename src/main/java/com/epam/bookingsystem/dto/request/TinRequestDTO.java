package com.epam.bookingsystem.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TinRequestDTO extends RequestDto {

    @Size(min = 8)
    private String serialNumber;
    @NotBlank
    private String document;


    public TinRequestDTO() {
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

    @Override
    public String toString() {
        return "TinRequestDTO{" +
                "serialNumber='" + serialNumber + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
