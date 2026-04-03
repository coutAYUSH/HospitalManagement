package com.cg.hospitalmanagementsystem.controllerTest;


import com.cg.hospitalmanagementsystem.controller.PhysicianController;
import com.cg.hospitalmanagementsystem.dto.request.PhysicianRequest;
import com.cg.hospitalmanagementsystem.dto.response.PhysicianPatientResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.Prescribes;
import com.cg.hospitalmanagementsystem.service.imp.DoctorServiceImp;
import com.cg.hospitalmanagementsystem.filter.JwtFilter;
import com.cg.hospitalmanagementsystem.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PhysicianController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PhysicianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorServiceImp doctorServiceImp;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllPatients() throws Exception {
        PhysicianRequest request = new PhysicianRequest();
        request.setId(1);

        PhysicianPatientResponse response = new PhysicianPatientResponse();
        List<PhysicianPatientResponse> responses = Arrays.asList(response);

        Mockito.when(doctorServiceImp.allAssignedPatients(Mockito.any(PhysicianRequest.class)))
                .thenReturn(responses);

        mockMvc.perform(get("/physician/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllAppointments() throws Exception {
        PhysicianRequest request = new PhysicianRequest();
        request.setId(1);

        Appointment appointment = new Appointment();
        List<Appointment> appointments = Arrays.asList(appointment);

        Mockito.when(doctorServiceImp.allAssignedAppointments(Mockito.any(PhysicianRequest.class)))
                .thenReturn(appointments);

        mockMvc.perform(get("/physician/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllPrescriptions() throws Exception {
        PhysicianRequest request = new PhysicianRequest();
        request.setId(1);

        Prescribes prescribes = new Prescribes();
        List<Prescribes> prescribesList = Arrays.asList(prescribes);

        Mockito.when(doctorServiceImp.allAssignedPrescriptions(Mockito.any(PhysicianRequest.class)))
                .thenReturn(prescribesList);

        mockMvc.perform(get("/physician/prescribes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}