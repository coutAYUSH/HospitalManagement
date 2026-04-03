package com.cg.hospitalmanagementsystem.controller;

import com.cg.hospitalmanagementsystem.dto.request.NurseRequest;
import com.cg.hospitalmanagementsystem.dto.response.NurseResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.OnCall;
import com.cg.hospitalmanagementsystem.service.imp.NurseServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    private final NurseServiceImp nurseServiceImp;

    public NurseController(NurseServiceImp nurseServiceImp){
        this.nurseServiceImp = nurseServiceImp;
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments(@RequestBody NurseRequest nurseRequest){
        List<Appointment> appointments = nurseServiceImp.allAssginedAppointments(nurseRequest);
        return ResponseEntity.ok(appointments);

    }

    @GetMapping("/oncalls")
    public ResponseEntity<List<OnCall>> getAllOnCalls(@RequestBody NurseRequest nurseRequest){
        List<OnCall> onCalls = nurseServiceImp.allAssignedOnCalls(nurseRequest);
        return ResponseEntity.ok(onCalls);
    }

    //Get all nurses
    @GetMapping("/allnurse")
    public ResponseEntity<List<NurseResponse>> getAllNurses() {
        List<NurseResponse> nurses = nurseServiceImp.getAllNurses();
        return ResponseEntity.ok(nurses);
    }


}
