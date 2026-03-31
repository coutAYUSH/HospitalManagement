package com.cg.hospitalmanagementsystem.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponseDto {

    public Integer roomNumber;
    public String roomType;
    public Integer blockFloor;
    public Integer blockCode;
    public Boolean unavailable;
}