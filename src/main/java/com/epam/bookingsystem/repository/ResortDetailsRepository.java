package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.ResortDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResortDetailsRepository extends JpaRepository<ResortDetails, Integer> {
}
