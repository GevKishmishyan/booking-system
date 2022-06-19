package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.Resort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResortRepository extends JpaRepository<Resort, Long> {

}
