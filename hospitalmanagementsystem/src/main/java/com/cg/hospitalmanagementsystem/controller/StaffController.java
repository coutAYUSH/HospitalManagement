package com.cg.hospitalmanagementsystem.controller;

import com.cg.hospitalmanagementsystem.dto.request.StaffLoginRequest;
import com.cg.hospitalmanagementsystem.dto.request.StaffRegisterRequest;
import com.cg.hospitalmanagementsystem.entity.Nurse;
import com.cg.hospitalmanagementsystem.entity.Patient;
import com.cg.hospitalmanagementsystem.entity.Physician;
import com.cg.hospitalmanagementsystem.service.imp.StaffServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffServiceImp staffServiceImp;

    public StaffController(StaffServiceImp staffServiceImp){
        this.staffServiceImp = staffServiceImp;
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


}

