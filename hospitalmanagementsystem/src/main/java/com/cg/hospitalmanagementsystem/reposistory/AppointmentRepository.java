package com.cg.hospitalmanagementsystem.reposistory;

import com.cg.hospitalmanagementsystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


    @Query("SELECT a FROM Appointment a WHERE a.physician.employeeId = :physicianId")
    List<Appointment> allAppointmentsByPhysicianId(@Param("physicianId") Integer physicianId);




    @Query("SELECT a FROM Appointment a WHERE a.prepNurse.employeeId = :nurseId")
    List<Appointment> allAppointmentByNurseId(@Param("nurseId") Integer nurseId);


}
