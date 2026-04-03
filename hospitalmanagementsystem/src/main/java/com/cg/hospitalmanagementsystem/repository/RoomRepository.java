package com.cg.hospitalmanagementsystem.repository;

import com.cg.hospitalmanagementsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r WHERE r.roomNumber = :roomNumber")
    Optional<Room> getRoomById(@Param("roomNumber") Integer roomNumber);

    @Query("SELECT r FROM Room r WHERE r.unavailable = false")
    Optional<List<Room>> getAvailableRooms();
}
