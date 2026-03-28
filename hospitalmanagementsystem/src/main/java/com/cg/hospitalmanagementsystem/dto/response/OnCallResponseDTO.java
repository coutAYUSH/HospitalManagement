package com.cg.hospitalmanagementsystem.dto.response;

import java.time.LocalDateTime;

public class OnCallResponseDTO {

    public Integer nurseId;
    public Integer blockFloor;
    public Integer blockCode;

    public LocalDateTime onCallStart;
    public LocalDateTime onCallEnd;
}
