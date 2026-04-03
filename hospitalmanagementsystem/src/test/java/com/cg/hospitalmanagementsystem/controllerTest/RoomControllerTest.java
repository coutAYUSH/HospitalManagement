package com.cg.hospitalmanagementsystem.controllerTest;


import com.cg.hospitalmanagementsystem.controller.RoomController;
import com.cg.hospitalmanagementsystem.dto.response.RoomResponse;
import com.cg.hospitalmanagementsystem.service.imp.RoomServiceImp;
import com.cg.hospitalmanagementsystem.filter.JwtFilter;
import com.cg.hospitalmanagementsystem.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoomController.class)
@AutoConfigureMockMvc(addFilters = false)
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomServiceImp roomServiceImp;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetRoomById() throws Exception {
        RoomResponse room = new RoomResponse();
        Mockito.when(roomServiceImp.getRoomById(1)).thenReturn(room);

        mockMvc.perform(get("/api/room/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAvailableRooms() throws Exception {
        RoomResponse room = new RoomResponse();
        List<RoomResponse> rooms = Arrays.asList(room);

        Mockito.when(roomServiceImp.getAvailableRooms()).thenReturn(rooms);

        mockMvc.perform(get("/api/availableRoom"))
                .andExpect(status().isOk());
    }
}
