package com.cg.hospitalmanagementsystem.repository;

import com.cg.hospitalmanagementsystem.entity.Prescribes;
import com.cg.hospitalmanagementsystem.entity.id.PrescribesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PrescriptionRepository extends JpaRepository<Prescribes, PrescribesId> {


    @Query("SELECT p FROM Prescribes p WHERE p.physician.employeeId = :physicianId")
    List<Prescribes> getPrescriptionsByPhysicianId(@Param("physicianId") Integer physicianId);
}
