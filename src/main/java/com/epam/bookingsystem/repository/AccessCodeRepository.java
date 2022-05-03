package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.AccessCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessCodeRepository extends JpaRepository<AccessCode,String> {
    Optional<AccessCode> findByCode(String code);
    Optional<AccessCode> findByUserId(Long id);
    void deleteById(Long id);
}
