package com.cg.hospitalmanagementsystem.service.imp;

import com.cg.hospitalmanagementsystem.dto.request.NurseRequest;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.OnCall;
import com.cg.hospitalmanagementsystem.reposistory.AppointmentRepository;
import com.cg.hospitalmanagementsystem.reposistory.OnCallRepository;
import com.cg.hospitalmanagementsystem.service.NurseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImp implements NurseService {


    private final AppointmentRepository appointmentRepository;
    private final OnCallRepository onCallRepository;


    public NurseServiceImp(AppointmentRepository appointmentRepository, OnCallRepository onCallRepository){
        this.appointmentRepository = appointmentRepository;
        this.onCallRepository = onCallRepository;
    }
    @Override
    public List<Appointment> allAssginedAppointments(NurseRequest nurseRequest) {
        List<Appointment> appointments = appointmentRepository.allAppointmentByNurseId(nurseRequest.getId());
        return appointments;
    }


    @Override
    public List<OnCall> allAssignedOnCalls(NurseRequest nurseRequest) {
        List<OnCall> onCalls = onCallRepository.allCallsByNurseId(nurseRequest.getId());
        return onCalls;
    }




}
