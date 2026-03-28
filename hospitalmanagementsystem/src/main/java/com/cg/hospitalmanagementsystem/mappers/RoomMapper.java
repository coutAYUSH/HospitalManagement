package com.cg.hospitalmanagementsystem.mappers;

import com.cg.hospitalmanagementsystem.dto.request.RoomRequestDTO;
import com.cg.hospitalmanagementsystem.dto.response.RoomResponseDTO;
import com.cg.hospitalmanagementsystem.entity.Room;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Room toEntity(RoomRequestDTO dto) {
        return modelMapper.map(dto, Room.class);
    }

    public RoomResponseDTO toDTO(Room entity) {
        return modelMapper.map(entity, RoomResponseDTO.class);
    }
}
