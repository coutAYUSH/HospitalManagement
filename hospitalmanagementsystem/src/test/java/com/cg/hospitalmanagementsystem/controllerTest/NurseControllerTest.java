package com.cg.hospitalmanagementsystem.controllerTest;




import com.cg.hospitalmanagementsystem.controller.NurseController;
import com.cg.hospitalmanagementsystem.dto.request.NurseRequest;
import com.cg.hospitalmanagementsystem.dto.response.NurseResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.OnCall;
import com.cg.hospitalmanagementsystem.filter.JwtFilter;
import com.cg.hospitalmanagementsystem.service.imp.NurseServiceImp;
import com.cg.hospitalmanagementsystem.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(NurseController.class)
@AutoConfigureMockMvc(addFilters = false)
public class NurseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private JwtUtil jwtUtil;
    @MockBean
    private NurseServiceImp nurseServiceImp;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllAppointments() throws Exception {

        NurseRequest request = new NurseRequest();
        request.setId(1);
        request.setName("Rachit");

        Appointment appointment = new Appointment();
        List<Appointment> appointments = Arrays.asList(appointment);

        Mockito.when(nurseServiceImp.allAssginedAppointments(Mockito.any(NurseRequest.class)))
                .thenReturn(appointments);

        mockMvc.perform(get("/nurse/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllOnCalls() throws Exception {

        NurseRequest request = new NurseRequest();
        request.setId(1);
        request.setName("Rachit");

        OnCall onCall = new OnCall();
        List<OnCall> onCalls = Arrays.asList(onCall);

        Mockito.when(nurseServiceImp.allAssignedOnCalls(Mockito.any(NurseRequest.class)))
                .thenReturn(onCalls);

        mockMvc.perform(get("/nurse/oncalls")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllNurses() throws Exception {

        NurseResponse nurse = NurseResponse.builder()
                .employeeId(1)
                .name("Rachit")
                .position("Staff Nurse")
                .registered(true)
                .ssn(1234)
                .build();

        List<NurseResponse> nurses = Arrays.asList(nurse);

        Mockito.when(nurseServiceImp.getAllNurses())
                .thenReturn(nurses);

        mockMvc.perform(get("/nurse/allnurse"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Rachit"));
    }
}