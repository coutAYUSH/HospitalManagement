package com.cg.hospitalmanagementsystem.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "procedures")
public class Procedure {
    @Id
    @Column(name = "Code")
    private Integer code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Cost")
    private Double cost;

}
