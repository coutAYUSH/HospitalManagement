package com.cg.hospitalmanagementsystem.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnCallRequestDto {

    public Integer nurseId;
    public Integer blockFloor;
    public Integer blockCode;

    public LocalDateTime onCallStart;
    public LocalDateTime onCallEnd;

}