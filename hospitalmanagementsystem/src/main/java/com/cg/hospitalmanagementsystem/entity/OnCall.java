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
    @JoinColumns({ @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor", insertable = false, updatable = false),
            @JoinColumn(name = "BlockCode", referencedColumnName = "BlockCode", insertable = false, updatable = false)
    })
    private Block block;
}
