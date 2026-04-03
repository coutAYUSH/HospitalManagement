package com.cg.hospitalmanagementsystem.controllerTest;

import com.cg.hospitalmanagementsystem.controller.StaffController;
import com.cg.hospitalmanagementsystem.dto.request.StaffRegisterRequest;
import com.cg.hospitalmanagementsystem.dto.response.PatientResponse;
import com.cg.hospitalmanagementsystem.dto.response.ProcedureResponse;
import com.cg.hospitalmanagementsystem.dto.response.StayResponse;
import com.cg.hospitalmanagementsystem.dto.response.TrainedInResponse;
import com.cg.hospitalmanagementsystem.entity.*;
import com.cg.hospitalmanagementsystem.service.StayService;
import com.cg.hospitalmanagementsystem.service.imp.ProcedureServiceImp;
import com.cg.hospitalmanagementsystem.service.imp.StaffServiceImp;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StaffController.class)
@AutoConfigureMockMvc(addFilters = false)
public class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StaffServiceImp staffServiceImp;

    @MockBean
    private ProcedureServiceImp procedureServiceImp;

    @MockBean
    private StayService stayService;

    @MockBean
    private JwtFilter jwtFilter;

    @MockBean
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegister() throws Exception {
        StaffRegisterRequest request = new StaffRegisterRequest();

        mockMvc.perform(post("/staff/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Staff registered successfully"));
    }

    @Test
    void testGetPatients() throws Exception {
        List<Patient> patients = Arrays.asList(new Patient());
        Mockito.when(staffServiceImp.fetchAllPatient()).thenReturn(patients);

        mockMvc.perform(get("/staff/allpatients"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetPhysicians() throws Exception {
        List<Physician> list = Arrays.asList(new Physician());
        Mockito.when(staffServiceImp.fetchAllPhysician()).thenReturn(list);

        mockMvc.perform(get("/staff/allphysicians"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetNurses() throws Exception {
        List<Nurse> list = Arrays.asList(new Nurse());
        Mockito.when(staffServiceImp.fetchAllNurse()).thenReturn(list);

        mockMvc.perform(get("/staff/allnurses"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetPatientById() throws Exception {
        PatientResponse response = new PatientResponse();
        Mockito.when(staffServiceImp.fetchPatientById(1)).thenReturn(response);

        mockMvc.perform(get("/staff/patientById/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAppointmentById() throws Exception {
        Appointment appointment = new Appointment();
        Mockito.when(staffServiceImp.getAppointmentById(1)).thenReturn(appointment);

        mockMvc.perform(get("/staff/appointments/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAppointmentsByPatientId() throws Exception {
        List<Appointment> list = Arrays.asList(new Appointment());
        Mockito.when(staffServiceImp.getAllAppointmentsByPatientId(1)).thenReturn(list);

        mockMvc.perform(get("/staff/appointmentsByPatientId/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllProcedures() throws Exception {
        List<ProcedureResponse> list = Arrays.asList(new ProcedureResponse());
        Mockito.when(procedureServiceImp.getAllProcedures()).thenReturn(list);

        mockMvc.perform(get("/staff/procedure/all"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStayById() throws Exception {
        StayResponse response = new StayResponse();
        Mockito.when(stayService.getStayById(1)).thenReturn(response);

        mockMvc.perform(get("/staff/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStaysByPatientId() throws Exception {
        List<StayResponse> list = Arrays.asList(new StayResponse());
        Mockito.when(stayService.getStaysByPatientId(1)).thenReturn(list);

        mockMvc.perform(get("/staff/stayOfPatient/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetTrainedInByPhysicianId() throws Exception {
        List<TrainedInResponse> list = Arrays.asList(new TrainedInResponse());
        Mockito.when(staffServiceImp.getByPhysicianId(1)).thenReturn(list);

        mockMvc.perform(get("/staff/physicianTrainedIn/1"))
                .andExpect(status().isOk());
    }
}