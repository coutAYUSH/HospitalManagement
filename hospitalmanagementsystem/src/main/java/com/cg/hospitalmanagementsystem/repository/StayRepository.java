package com.cg.hospitalmanagementsystem.repository;


import com.cg.hospitalmanagementsystem.entity.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StayRepository extends JpaRepository<Stay, Integer> {
    @Query("SELECT s FROM Stay s JOIN FETCH s.patient JOIN FETCH s.room WHERE s.stayId = :id")
    Optional<Stay> findByIdWithPatientAndRoom(@Param("id") Integer id);

    @Query("SELECT s FROM Stay s JOIN FETCH s.patient JOIN FETCH s.room WHERE s.patient.ssn = :patientId")
    List<Stay> findByPatientIdWithDetails(@Param("patientId") Integer patientId);
}