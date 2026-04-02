package com.cg.hospitalmanagementsystem.reposistory;

import com.cg.hospitalmanagementsystem.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Physician,Integer> {


    @Query("SELECT p FROM Physician p")
    List<Physician> allPhysicians();


}

