package com.cg.hospitalmanagementsystem.repository;

import com.cg.hospitalmanagementsystem.entity.OnCall;
import com.cg.hospitalmanagementsystem.entity.id.OnCallId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OnCallRepository extends JpaRepository<OnCall, OnCallId> {


    @Query("SELECT c FROM OnCall c WHERE c.nurse.employeeId = :nurseId")
    List<OnCall> allCallsByNurseId(@Param("nurseId") Integer nurseId);
}

