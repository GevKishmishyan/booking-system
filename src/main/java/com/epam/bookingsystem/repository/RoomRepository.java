package com.epam.bookingsystem.repository;

import com.epam.bookingsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
