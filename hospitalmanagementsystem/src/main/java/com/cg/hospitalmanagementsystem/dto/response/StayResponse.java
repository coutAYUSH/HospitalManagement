package com.cg.hospitalmanagementsystem.dto.response;


import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StayResponse {

    private Integer stayId;
    private LocalDateTime stayStart;
    private LocalDateTime stayEnd;

    private PatientResponse patient;
    private Integer roomNumber;
}
