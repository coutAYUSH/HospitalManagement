package com.cg.hospitalmanagementsystem.entity.id;


import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainedInId implements Serializable {
    private Integer physicianId;
    private Integer treatmentId;
}