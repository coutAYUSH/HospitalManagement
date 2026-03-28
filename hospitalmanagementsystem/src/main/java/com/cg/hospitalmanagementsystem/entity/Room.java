package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    private Integer roomNumber;

    private String roomType;

    private Integer blockFloor;
    private Integer blockCode;

    private Boolean unavailable;
}
