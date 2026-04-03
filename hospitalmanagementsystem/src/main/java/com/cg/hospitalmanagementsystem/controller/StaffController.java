package com.cg.hospitalmanagementsystem.controller;

import com.cg.hospitalmanagementsystem.dto.request.NurseRequest;
import com.cg.hospitalmanagementsystem.dto.request.StaffLoginRequest;
import com.cg.hospitalmanagementsystem.dto.request.StaffRegisterRequest;
import com.cg.hospitalmanagementsystem.dto.response.PatientResponse;
import com.cg.hospitalmanagementsystem.entity.*;
import com.cg.hospitalmanagementsystem.service.imp.StaffServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffServiceImp staffServiceImp;
    private final ProcedureServiceImp procedureServiceImp;

    public StaffController(StaffServiceImp staffServiceImp, ProcedureServiceImp procedureServiceImp){
        this.staffServiceImp = staffServiceImp;
        this.procedureServiceImp = procedureServiceImp;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody StaffRegisterRequest staffRegisterRequest){
        staffServiceImp.registerStaff(staffRegisterRequest);
        return ResponseEntity.ok("Staff registered successfully");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody StaffLoginRequest staffLoginRequest){
        staffServiceImp.loginStaff(staffLoginRequest);
        return ResponseEntity.ok("Logged In");
    }

    @GetMapping("/allpatients")
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients = staffServiceImp.fetchAllPatient();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/allphysicians")
    public ResponseEntity<List<Physician>> getPhysicians(){
        List<Physician> physicians = staffServiceImp.fetchAllPhysician();
        return ResponseEntity.ok(physicians);
    }


    @GetMapping("/allnurses")
    public ResponseEntity<List<Nurse>> getNurses(){
        List<Nurse> nurses = staffServiceImp.fetchAllNurse();
        return ResponseEntity.ok(nurses);
    }

    @GetMapping("/patientById/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Integer id){
        PatientResponse patient = staffServiceImp.fetchPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentsById(@PathVariable Integer id){
        Appointment appointment = staffServiceImp.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }
    @GetMapping("/appointmentsByPatientId/{id}")
    public ResponseEntity<List<Appointment>> getAllAppointmentsByPatientId(@PathVariable Integer id){
        List<Appointment> appointments = staffServiceImp.getAllAppointmentsByPatientId(id);
        return ResponseEntity.ok(appointments);

    }




}

