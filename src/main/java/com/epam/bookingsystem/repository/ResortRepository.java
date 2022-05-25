package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResortRepository extends JpaRepository<Resort, Long> {



}
