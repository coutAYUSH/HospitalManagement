package com.cg.hospitalmanagementsystem.entity.id;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class BlockId implements Serializable {


    @Column(name = "BlockFloor")
    private Integer blockFloor;


    @Column(name = "BlockCode")
    private Integer blockCode;




}

