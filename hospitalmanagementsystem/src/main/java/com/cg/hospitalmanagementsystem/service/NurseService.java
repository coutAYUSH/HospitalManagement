package com.cg.hospitalmanagementsystem.service;




import com.cg.hospitalmanagementsystem.dto.request.NurseRequest;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.OnCall;

import java.util.List;


public interface NurseService {


    List<Appointment> allAssginedAppointments(NurseRequest nurseRequest);


    List<OnCall> allAssignedOnCalls(NurseRequest nurseRequest);

}


