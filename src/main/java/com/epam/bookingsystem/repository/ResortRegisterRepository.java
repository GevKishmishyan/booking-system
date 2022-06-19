package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.ResortRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResortRegisterRepository extends JpaRepository<ResortRegister, Long> {

    List<ResortRegister> findAllByResort_Address_Country(String country);
}
