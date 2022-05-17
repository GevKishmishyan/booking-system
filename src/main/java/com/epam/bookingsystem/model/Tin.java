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

    public Tin() {
    }

    public Tin(long id, @Size(min = 8) String serialNumber, @NotBlank String document) {
        super(id);
        this.serialNumber = serialNumber;
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tin tin = (Tin) o;
        return Objects.equals(serialNumber, tin.serialNumber) && Objects.equals(document, tin.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, document);
    }

    @Override
    public String toString() {
        return "Tin{" +
                "serialNumber='" + serialNumber + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
