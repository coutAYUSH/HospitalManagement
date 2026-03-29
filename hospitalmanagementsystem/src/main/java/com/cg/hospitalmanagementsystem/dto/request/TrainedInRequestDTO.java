package com.cg.hospitalmanagementsystem.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainedInRequestDTO {
    private Integer physicianId;
    private Integer procedureId;
    private LocalDateTime certificationDate;
    private LocalDateTime certificationExpires;
}