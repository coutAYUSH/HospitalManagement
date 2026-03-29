package com.cg.hospitalmanagementsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NurseResponseDTO {

    private Integer EmployeeId;
    private String Name;
    private String Position;
    private Boolean Registered;
    private Integer ssn;
}