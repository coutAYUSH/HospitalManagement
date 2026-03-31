package com.cg.hospitalmanagementsystem.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequestDto {

    public Integer ssn;
    public String name;
    public String address;
    public String phone;
    public Integer insuranceId;
    public Integer pcpId;
}