package com.cg.hospitalmanagementsystem.entity.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OnCallId implements Serializable {

    private Integer nurseId;
    private Integer blockFloor;
    private Integer blockCode;
    private LocalDateTime onCallStart;
}
