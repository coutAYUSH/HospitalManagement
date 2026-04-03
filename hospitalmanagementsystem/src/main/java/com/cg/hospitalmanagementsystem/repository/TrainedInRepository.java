package com.cg.hospitalmanagementsystem.repository;

import com.cg.hospitalmanagementsystem.entity.TrainedIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainedInRepository extends JpaRepository<TrainedIn , Integer> {
//    @Query("SELECT t FROM TrainedIn t " +
//            "JOIN FETCH t.physician " +
//            "JOIN FETCH t.procedure " +
//            "WHERE t.physician.employeeId = :physicianId")
//    List<TrainedIn> findByPhysicianWithDetails(@Param("physicianId") Integer physicianId);

    @Query("SELECT t FROM TrainedIn t WHERE t.id.physicianId = :physicianId")
    List<TrainedIn> findByPhysicianWithDetails(@Param("physicianId") Integer physicianId);
}
