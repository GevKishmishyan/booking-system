package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.ResortRegister;
import com.epam.bookingsystem.model.enums.ResortRegisterStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResortRegisterRepository extends JpaRepository<ResortRegister, Long> {

    Page<ResortRegister> findAllByResort_Address_CountryAndResortRegisterStatusIsNot(String country, ResortRegisterStatus resortRegisterStatus, Pageable pageable);

    Page<ResortRegister> findAll(Pageable pageable);

}

