package com.cg.hospitalmanagementsystem.entity.id;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlockId implements Serializable {
    private Integer blockFloor;
    private Integer blockCode;
}
