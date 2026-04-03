package com.cg.hospitalmanagementsystem.service.imp;

import com.cg.hospitalmanagementsystem.dto.response.RoomResponse;
import com.cg.hospitalmanagementsystem.entity.Room;
import com.cg.hospitalmanagementsystem.exception.NoRoomsAvailableException;
import com.cg.hospitalmanagementsystem.repository.RoomRepository;
import com.cg.hospitalmanagementsystem.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImp(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomResponse getRoomById(Integer roomNumber) {

        Room room = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        return mapToDto(room);
    }
    public List<RoomResponse> getAvailableRooms() {
        List<Room> availableRooms = roomRepository.getAvailableRooms()
                .orElseThrow(() -> new NoRoomsAvailableException("No Available rooms right now!"));

        return availableRooms.stream()
                .map(this::mapToDto)
                .toList();
    }

    private RoomResponse mapToDto(Room room) {

        Integer blockCode = null;
        Integer blockFloor = null;

        if (room.getBlock() != null && room.getBlock().getId() != null) {
            blockCode = room.getBlock().getId().getBlockCode();
            blockFloor = room.getBlock().getId().getBlockFloor();
        }

        return RoomResponse.builder()
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .blockCode(blockCode)
                .blockFloor(blockFloor)
                .unavailable(room.getUnavailable())
                .build();
    }


}
