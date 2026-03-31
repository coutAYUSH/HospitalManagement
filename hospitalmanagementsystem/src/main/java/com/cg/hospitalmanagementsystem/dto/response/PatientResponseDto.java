package com.cg.hospitalmanagementsystem.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDto {

    public Integer ssn;
    public String name;
    public String address;
    public String phone;
    public Integer insuranceId;
    public Integer pcpId;
}