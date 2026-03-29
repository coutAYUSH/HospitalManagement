package com.cg.hospitalmanagementsystem.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDTO {
    private Integer appointmentId;
    private String physicianName;
    private String nurseName;
    private LocalDateTime start;
    private LocalDateTime end;
    private String examinationRoom;
}