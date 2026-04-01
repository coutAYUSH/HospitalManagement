package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @Column(name = "DepartmentID")
    private Integer departmentId;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Head", referencedColumnName = "EmployeeID")
    private Physician head;


}


