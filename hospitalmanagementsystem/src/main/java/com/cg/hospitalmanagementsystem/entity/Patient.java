package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    private Integer ssn;

    private String name;
    private String address;
    private String phone;
    private Integer insuranceId;

    @ManyToOne
    @JoinColumn(name = "pcp")
    private Physician primaryCarePhysician;
}
