package com.cg.hospitalmanagementsystem.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnCallResponseDto {

    public Integer nurseId;
    public Integer blockFloor;
    public Integer blockCode;

    public LocalDateTime onCallStart;
    public LocalDateTime onCallEnd;
}