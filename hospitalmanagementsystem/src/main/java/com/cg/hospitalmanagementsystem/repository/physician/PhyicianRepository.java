package com.cg.hospitalmanagementsystem.repository.physician;

import com.cg.hospitalmanagementsystem.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhyicianRepository extends JpaRepository<Physician, Integer> {
}
