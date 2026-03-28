package com.cg.hospitalmanagementsystem.dto.request;

import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;

public class RoomRequestDTO {

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
