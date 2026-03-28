package com.cg.hospitalmanagementsystem.dto.request;

import java.time.LocalDateTime;

public class OnCallRequestDTO {

    public Integer nurseId;
    public Integer blockFloor;
    public Integer blockCode;

    public LocalDateTime onCallStart;
    public LocalDateTime onCallEnd;
}
