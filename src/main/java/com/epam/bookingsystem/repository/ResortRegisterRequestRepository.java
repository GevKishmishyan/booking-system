package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.ResortRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResortRegisterRequestRepository extends JpaRepository<ResortRegisterRequest, Integer> {
}
