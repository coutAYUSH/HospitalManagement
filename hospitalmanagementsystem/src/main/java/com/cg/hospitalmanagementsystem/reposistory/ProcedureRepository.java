package com.cg.hospitalmanagementsystem.reposistory;

import com.cg.hospitalmanagementsystem.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
}