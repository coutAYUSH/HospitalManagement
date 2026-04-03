package com.cg.hospitalmanagementsystem.repository;

import com.cg.hospitalmanagementsystem.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff,Integer> {

    @Query("SELECT s FROM Staff s WHERE s.staffEmail = :staffEmail")
    Optional<Staff> findByEmail(@Param("staffEmail") String staffEmail);
}
