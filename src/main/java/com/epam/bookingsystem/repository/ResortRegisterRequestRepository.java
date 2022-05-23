package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.ResortRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResortRegisterRequestRepository extends JpaRepository<ResortRegisterRequest, Long> {


   // @Query("select * from booking_system.resort_register_request where")
   // List<ResortRegisterRequest> findAllByResortRegisterCountry(String country);


    @Override
    List<ResortRegisterRequest> findAll();
}
