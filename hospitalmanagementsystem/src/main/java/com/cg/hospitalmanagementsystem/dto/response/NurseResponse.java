package com.cg.hospitalmanagementsystem.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NurseResponse {

    private Integer employeeId;
    private String name;
    private String position;
    private Boolean registered;
    private Integer ssn;
}
