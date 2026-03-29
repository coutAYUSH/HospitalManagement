package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Physician {

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "SSN")
    private Integer ssn;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;
}
