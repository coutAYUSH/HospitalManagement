package com.cg.hospitalmanagementsystem.entity;

import com.cg.hospitalmanagementsystem.entity.id.TrainedInId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "trained_in")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainedIn {

    @EmbeddedId
    private TrainedInId id;

    @ManyToOne
    @MapsId("physicianId")
    @JoinColumn(name = "physician")
    private Physician physician;

    @ManyToOne
    @MapsId("treatmentId")
    @JoinColumn(name = "treatment")
    private Procedures procedures;

    private LocalDateTime certificationDate;
    private LocalDateTime certificationExpires;
}
