package com.cg.hospitalmanagementsystem.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainedInResponseDTO {
    private String physicianName;
    private String procedureName;
    private LocalDateTime certificationDate;
    private LocalDateTime certificationExpires;
}
