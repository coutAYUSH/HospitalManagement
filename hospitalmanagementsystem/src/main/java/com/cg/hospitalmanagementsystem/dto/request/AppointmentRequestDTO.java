package com.cg.hospitalmanagementsystem.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO {
    private Integer physicianId;
    private Integer nurseId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String examinationRoom;
}