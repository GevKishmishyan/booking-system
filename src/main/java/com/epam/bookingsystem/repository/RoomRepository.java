package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findRoomByResort(Resort resort);
}
