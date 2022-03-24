package com.epam.bookingsystem.repo;

import com.epam.bookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Integer> {

}
