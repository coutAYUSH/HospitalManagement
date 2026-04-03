package com.cg.hospitalmanagementsystem.controllerTest;



import com.cg.hospitalmanagementsystem.controller.NurseController;
import com.cg.hospitalmanagementsystem.dto.request.NurseRequest;
import com.cg.hospitalmanagementsystem.dto.response.NurseResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.OnCall;
import com.cg.hospitalmanagementsystem.service.imp.NurseServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NurseController.class)
public class NurseControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
        // set fields if required

        List<Appointment> appointmentList = Arrays.asList(appointment);

        when(nurseServiceImp.allAssginedAppointments(request))
                .thenReturn(appointmentList);

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
        // set fields if required

        List<OnCall> onCallList = Arrays.asList(onCall);

        when(nurseServiceImp.allAssignedOnCalls(request))
                .thenReturn(onCallList);

        mockMvc.perform(get("/nurse/oncalls")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllNurses() throws Exception {
        NurseResponse nurseResponse = NurseResponse.builder()
                .employeeId(1)
                .name("Rachit")
                .position("Head Nurse")
                .registered(true)
                .ssn(11111122)
                .build();

        List<NurseResponse> nurseResponseList = List.of(nurseResponse);

        when(nurseServiceImp.getAllNurses()).thenReturn(nurseResponseList);

        mockMvc.perform(get("/nurse/allnurse")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].employeeId").value(1))
                .andExpect(jsonPath("$[0].name").value("Rachit"))
                .andExpect(jsonPath("$[0].position").value("Head Nurse"))
                .andExpect(jsonPath("$[0].registered").value(true))
                .andExpect(jsonPath("$[0].ssn").value(11111122));
    }
}