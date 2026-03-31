package com.cg.hospitalmanagementsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomRequestDto {

    @NotNull
    public Integer roomNumber;

    @NotBlank
    public String roomType;

    @NotNull
    public Integer blockFloor;

    @NotNull
    public Integer blockCode;

    public Boolean unavailable;
}