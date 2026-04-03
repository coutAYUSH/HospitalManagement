package com.cg.hospitalmanagementsystem.service.imp;

import com.cg.hospitalmanagementsystem.dto.request.NurseRequest;
import com.cg.hospitalmanagementsystem.dto.response.NurseResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.OnCall;
import com.cg.hospitalmanagementsystem.reposistory.AppointmentRepository;
import com.cg.hospitalmanagementsystem.reposistory.NurseRepository;
import com.cg.hospitalmanagementsystem.reposistory.OnCallRepository;
import com.cg.hospitalmanagementsystem.service.NurseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NurseServiceImp implements NurseService {


    private final AppointmentRepository appointmentRepository;
    private final OnCallRepository onCallRepository;

    private final NurseRepository nurseRepository;

    public NurseServiceImp(AppointmentRepository appointmentRepository, OnCallRepository onCallRepository, NurseRepository nurseRepository){
        this.appointmentRepository = appointmentRepository;
        this.onCallRepository = onCallRepository;
        this.nurseRepository = nurseRepository;
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


    @Override
    public List<NurseResponse> getAllNurses() {

        return nurseRepository.findAll()
                .stream()
                .map(nurse -> NurseResponse.builder()
                        .employeeId(nurse.getEmployeeId())
                        .name(nurse.getName())
                        .position(nurse.getPosition())
                        .registered(nurse.getRegistered())
                        .ssn(nurse.getSsn())
                        .build())
                .collect(Collectors.toList());
    }



}
