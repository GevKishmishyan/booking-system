package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.AccessCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessCodeRepository extends JpaRepository<AccessCode,Long> {
    Optional<AccessCode> findByCode(String code);
}
