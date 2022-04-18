package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tin")
public class Tin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Size(min = 8)
    private String serialNumber;
    @NotBlank
    private String document;

    public Tin(UUID id, @Size(min = 8) String serialNumber, @NotBlank String document) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.document = document;
    }

    public Tin() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tin tin = (Tin) o;
        return Objects.equals(id, tin.id) && Objects.equals(serialNumber, tin.serialNumber) && Objects.equals(document, tin.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, document);
    }

    @Override
    public String toString() {
        return "Tin{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
