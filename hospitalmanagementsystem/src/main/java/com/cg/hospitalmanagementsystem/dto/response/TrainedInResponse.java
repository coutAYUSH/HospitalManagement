package com.cg.hospitalmanagementsystem.dto.response;


import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainedInResponse {

    private Integer physicianId;
    private String physicianName;

    private Integer procedureId;
    private String procedureName;

    private LocalDateTime certificationDate;
    private LocalDateTime certificationExpires;
}
