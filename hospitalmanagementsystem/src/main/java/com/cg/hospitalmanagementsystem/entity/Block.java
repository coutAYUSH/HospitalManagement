package com.cg.hospitalmanagementsystem.entity;


import com.cg.hospitalmanagementsystem.entity.id.BlockId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(BlockId.class)
@Table(name = "block")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Block {

    @Id
    private Integer blockFloor;

    @Id
    private Integer blockCode;
}
