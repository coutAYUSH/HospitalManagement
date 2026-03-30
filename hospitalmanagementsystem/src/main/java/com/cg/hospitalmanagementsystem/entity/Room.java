package com.cg.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @Column(name = "RoomNumber")
    private Integer roomNumber;

    @Column(name = "RoomType")
    private String roomType;

    @ManyToOne
    @JoinColumns({ @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor"),
                    @JoinColumn(name = "BlockCode",referencedColumnName = "BlockCode")})
    private Block block;

    @Column(name = "Unavailable")
    private Boolean unavailable;
}
