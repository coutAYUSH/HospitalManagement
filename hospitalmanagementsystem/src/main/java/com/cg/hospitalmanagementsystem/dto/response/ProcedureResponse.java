package com.cg.hospitalmanagementsystem.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcedureResponse {

    private Integer code;
    private String name;
    private Double cost;
}