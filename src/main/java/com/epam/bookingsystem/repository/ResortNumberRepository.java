package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.ResortNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResortNumberRepository extends JpaRepository<ResortNumber, Long> {

}
