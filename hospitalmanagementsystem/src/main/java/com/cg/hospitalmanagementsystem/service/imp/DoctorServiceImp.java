package com.cg.hospitalmanagementsystem.service.imp;

import com.cg.hospitalmanagementsystem.dto.request.PhysicianRequest;
import com.cg.hospitalmanagementsystem.dto.response.PhysicianPatientResponse;
import com.cg.hospitalmanagementsystem.entity.Appointment;
import com.cg.hospitalmanagementsystem.entity.Patient;
import com.cg.hospitalmanagementsystem.entity.Prescribes;
import com.cg.hospitalmanagementsystem.repository.AppointmentRepository;
import com.cg.hospitalmanagementsystem.repository.DoctorRepository;
import com.cg.hospitalmanagementsystem.repository.PatientRepository;
import com.cg.hospitalmanagementsystem.repository.PrescriptionRepository;
import com.cg.hospitalmanagementsystem.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService {


    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final PrescriptionRepository prescriptionRepository;


    public DoctorServiceImp(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository,PatientRepository
            patientRepository, PrescriptionRepository prescriptionRepository){
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
    }




    private PhysicianPatientResponse mapToPhysicianPatientResponse(Patient patient){
        PhysicianPatientResponse patientResponse = new PhysicianPatientResponse();
        patientResponse.setName(patient.getName());
        patientResponse.setPhone(patient.getPhone());
        patientResponse.setAddress(patient.getAddress());
        return patientResponse;
    }
    @Override
    public List<PhysicianPatientResponse> allAssignedPatients(PhysicianRequest physicianRequest) {
        List<Patient> patients = patientRepository.allPatientByPhysicianId(physicianRequest.getId());


        List<PhysicianPatientResponse> patientResponses = patients.stream().map(this::mapToPhysicianPatientResponse).toList();


        return patientResponses;
    }


    @Override
    public List<Appointment> allAssignedAppointments(PhysicianRequest physicianRequest) {
        return appointmentRepository.allAppointmentsByPhysicianId(physicianRequest.getId());


    }


    @Override
    public List<Prescribes> allAssignedPrescriptions(PhysicianRequest physicianRequest) {
        List<Prescribes> prescribes = prescriptionRepository.getPrescriptionsByPhysicianId(physicianRequest.getId());
        return prescribes;
    }






}

