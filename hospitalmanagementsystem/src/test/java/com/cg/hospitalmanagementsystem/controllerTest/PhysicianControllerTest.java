package com.cg.hospitalmanagementsystem.controllerTest;


import com.cg.hospitalmanagementsystem.controller.PhysicianController;
import com.cg.hospitalmanagementsystem.dto.request.PhysicianRequest;
import com.cg.hospitalmanagementsystem.dto.response.PhysicianPatientResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.Prescribes;
import com.cg.hospitalmanagementsystem.service.imp.DoctorServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PhysicianController.class)
public class PhysicianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorServiceImp doctorServiceImp;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllPatients() throws Exception {

        PhysicianRequest request = new PhysicianRequest();
        request.setId(1);
        request.setName("Dr. John");
        request.setPosition("Cardiologist");

        PhysicianPatientResponse response = new PhysicianPatientResponse();
        // set fields if needed

        List<PhysicianPatientResponse> responseList = Arrays.asList(response);

        when(doctorServiceImp.allAssignedPatients(any(PhysicianRequest.class)))
                .thenReturn(responseList);

        mockMvc.perform(get("/physician/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllAppointments() throws Exception {

        PhysicianRequest request = new PhysicianRequest();
        request.setId(1);
        request.setName("Dr. John");
        request.setPosition("Cardiologist");

        Appointment appointment = new Appointment();
        List<Appointment> appointmentList = Arrays.asList(appointment);

        when(doctorServiceImp.allAssignedAppointments(any(PhysicianRequest.class)))
                .thenReturn(appointmentList);

        mockMvc.perform(get("/physician/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllPrescriptions() throws Exception {

        PhysicianRequest request = new PhysicianRequest();
        request.setId(1);
        request.setName("Dr. John");
        request.setPosition("Cardiologist");

        Prescribes prescribes = new Prescribes();
        List<Prescribes> prescribesList = Arrays.asList(prescribes);

        when(doctorServiceImp.allAssignedPrescriptions(any(PhysicianRequest.class)))
                .thenReturn(prescribesList);

        mockMvc.perform(get("/physician/prescribes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
