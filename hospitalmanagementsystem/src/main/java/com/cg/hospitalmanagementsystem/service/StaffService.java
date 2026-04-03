package com.cg.hospitalmanagementsystem.service;






import com.cg.hospitalmanagementsystem.dto.request.StaffLoginRequest;
import com.cg.hospitalmanagementsystem.dto.request.StaffRegisterRequest;
import com.cg.hospitalmanagementsystem.dto.response.TrainedInResponse;
import com.cg.hospitalmanagementsystem.entity.Nurse;
import com.cg.hospitalmanagementsystem.entity.Patient;
import com.cg.hospitalmanagementsystem.entity.Physician;

import java.util.List;


public interface StaffService {


    void registerStaff(StaffRegisterRequest staffRegisterRequest);


    void loginStaff(StaffLoginRequest staffLoginRequest);


    List<Patient> fetchAllPatient();


    List<Physician> fetchAllPhysician();


    List<Nurse> fetchAllNurse();

    List<TrainedInResponse> getByPhysicianId(Integer physicianId);


}


