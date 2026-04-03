package com.cg.hospitalmanagementsystem.repository;

import com.cg.hospitalmanagementsystem.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
}