package com.cg.hospitalmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @ManyToOne
    @JoinColumn(name = "physician")
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "prepNurse")
    private Nurse prepNurse;

    @Column(name = "starto")
    private LocalDateTime start;

    @Column(name = "endo")
    private LocalDateTime end;

    private String examinationRoom;
}
