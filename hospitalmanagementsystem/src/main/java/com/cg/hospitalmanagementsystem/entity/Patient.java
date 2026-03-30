package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @Column(name = "SSN")
    private Integer ssn;

    @Column(name = "Name")
    private String name;

    @Column(name="Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "InsuranceID")
    private Integer insuranceId;

    @ManyToOne
    @JoinColumn(name = "PCP", referencedColumnName = "EmployeeID")
    private Physician primaryCarePhysician;


}
