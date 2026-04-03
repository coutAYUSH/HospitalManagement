package com.cg.hospitalmanagementsystem.repository;

import com.cg.hospitalmanagementsystem.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse,Integer> {


    @Query("SELECT n FROM Nurse n")
    List<Nurse> allNurses();
}

