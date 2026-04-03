package com.cg.hospitalmanagementsystem.controller;

import com.cg.hospitalmanagementsystem.dto.request.PhysicianRequest;
import com.cg.hospitalmanagementsystem.dto.response.PhysicianPatientResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.Prescribes;
import com.cg.hospitalmanagementsystem.service.imp.DoctorServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/physician")
public class PhysicianController {

    private final DoctorServiceImp doctorServiceImp;

    public PhysicianController(DoctorServiceImp doctorServiceImp){
        this.doctorServiceImp = doctorServiceImp;
    }


    //Get all patients assigned to a specific physician
    @GetMapping("/patients")
    public ResponseEntity<List<PhysicianPatientResponse>> getAllPatients(@RequestBody PhysicianRequest physicianRequest){

        List<PhysicianPatientResponse> responses = doctorServiceImp.allAssignedPatients(physicianRequest);

        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllApointments(@RequestBody PhysicianRequest physicianRequest){
        List<Appointment> appointments = doctorServiceImp.allAssignedAppointments(physicianRequest);
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    @GetMapping("/prescribes")
    public ResponseEntity<List<Prescribes>> getAllPrescriptions(@RequestBody PhysicianRequest physicianRequest){
        List<Prescribes> prescribes = doctorServiceImp.allAssignedPrescriptions(physicianRequest);
        return ResponseEntity.status(HttpStatus.OK).body(prescribes);
    }


}

