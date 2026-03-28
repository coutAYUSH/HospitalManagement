package com.cg.hospitalmanagementsystem.entity;

import com.cg.hospitalmanagementsystem.entity.id.OnCallId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OnCall {

    @EmbeddedId
    private OnCallId id;

    @ManyToOne
    @MapsId("nurseId")
    @JoinColumn(name = "nurse")
    private Nurse nurse;

    private LocalDateTime onCallEnd;
}
