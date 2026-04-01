package com.cg.hospitalmanagementsystem.reposistory;

import com.cg.hospitalmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


    @Query("SELECT p FROM Patient p WHERE p.primaryCarePhysician.employeeId = :physicianId")
    List<Patient> allPatientByPhysicianId(@Param("physicianId") Integer physicianId);
}



