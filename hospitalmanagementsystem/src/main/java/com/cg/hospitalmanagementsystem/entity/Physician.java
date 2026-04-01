package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "physician")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Physician {


    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;


    @Column(name = "Name")
    private String name;


    @Column(name = "Position")
    private String position;


    @Column(name = "SSN")
    private Integer ssn;


}
