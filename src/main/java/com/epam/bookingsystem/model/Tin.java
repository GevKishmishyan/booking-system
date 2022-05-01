package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "tin")
public class Tin extends BaseEntity {
    @Size(min = 8)
    private String serialNumber;
    @NotBlank
    private String document;
    @OneToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    public Tin() {
    }

    public Tin(long id, String serialNumber, String document, Resort resort) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.document = document;
        this.resort = resort;
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

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tin tin = (Tin) o;
        return id == tin.id && Objects.equals(serialNumber, tin.serialNumber) && Objects.equals(document, tin.document) && Objects.equals(resort, tin.resort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, document, resort);
    }

    @Override
    public String toString() {
        return "Tin{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", document='" + document + '\'' +
                ", resort=" + resort +
                '}';
    }
}
