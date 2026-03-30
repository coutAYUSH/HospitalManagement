package com.cg.hospitalmanagementsystem.entity;

import com.cg.hospitalmanagementsystem.entity.id.OnCallId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "on_call")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnCall {

    @EmbeddedId
    private OnCallId id;

    @ManyToOne
    @MapsId("nurseId")
    @JoinColumn(name = "Nurse", referencedColumnName = "EmployeeID")
    private Nurse nurse;

    @ManyToOne
    @JoinColumns({ @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor"),
            @JoinColumn(name = "BlockCode", referencedColumnName = "BlockCode")
    })
    private Block block;
}
