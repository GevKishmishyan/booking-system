package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortNumber;
import com.epam.bookingsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResortNumberRepository extends JpaRepository<ResortNumber, Integer> {
    Optional<ResortNumber> findRoomByRoom(Room room);
}
