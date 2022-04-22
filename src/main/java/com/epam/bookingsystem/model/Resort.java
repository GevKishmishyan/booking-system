package com.epam.bookingsystem.model;


import com.epam.bookingsystem.model.enums.ResortType;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "resort")
public class Resort extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @Enumerated(EnumType.STRING)
    private ResortType resortType;
    @Min(1)
    @Max(5)
    private Integer star;
    @NotNull
    @Email
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String telephone;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Resort() {
    }

    public Resort(long id, String name, ResortType resortType,
                  Integer star, String email, String telephone,
                  String description) {
        this.id = id;
        this.name = name;
        this.resortType = resortType;
        this.star = star;
        this.email = email;
        this.telephone = telephone;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResortType getResortType() {
        return resortType;
    }

    public void setResortType(ResortType resortType) {
        this.resortType = resortType;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resort resort = (Resort) o;
        return id == resort.id && Objects.equals(name, resort.name) && resortType == resort.resortType && Objects.equals(star, resort.star) && Objects.equals(email, resort.email) && Objects.equals(telephone, resort.telephone) && Objects.equals(description, resort.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, resortType, star, email, telephone, description);
    }

    @Override
    public String toString() {
        return "Resort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resortType=" + resortType +
                ", star=" + star +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
