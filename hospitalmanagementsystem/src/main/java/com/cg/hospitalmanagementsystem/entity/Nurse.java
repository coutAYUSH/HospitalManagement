package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Nurse {
    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Position")
    private String position;

    @Column(name = "Registered")
    private Boolean registered;

    @Column(name = "SSN")
    private Integer ssn;
}
