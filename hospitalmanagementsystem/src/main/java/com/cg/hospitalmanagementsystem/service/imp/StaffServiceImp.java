package com.cg.hospitalmanagementsystem.service.imp;

import com.cg.hospitalmanagementsystem.dto.request.StaffLoginRequest;
import com.cg.hospitalmanagementsystem.dto.request.StaffRegisterRequest;
import com.cg.hospitalmanagementsystem.dto.response.PatientResponse;
import com.cg.hospitalmanagementsystem.dto.response.TrainedInResponse;
import com.cg.hospitalmanagementsystem.entity.*;
import com.cg.hospitalmanagementsystem.exception.*;
import com.cg.hospitalmanagementsystem.mapper.PatientMapper;
import com.cg.hospitalmanagementsystem.repository.*;
import com.cg.hospitalmanagementsystem.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImp implements StaffService {

    private final StaffRepository staffRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final AppointmentRepository appointmentRepository;
    private final TrainedInRepository trainedInRepository;

    public StaffServiceImp(StaffRepository staffRepository, PatientRepository patientRepository
            , DoctorRepository doctorRepository, NurseRepository nurseRepository, AppointmentRepository appointmentRepository, TrainedInRepository trainedInRepository) {
        this.staffRepository = staffRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
        this.appointmentRepository = appointmentRepository;
        this.trainedInRepository = trainedInRepository;
    }


    @Override
    public void registerStaff(StaffRegisterRequest staffRegisterRequest) {
        Staff new_staff = new Staff();
        new_staff.setStaffId(staffRegisterRequest.getId());
        new_staff.setStaffEmail(staffRegisterRequest.getEmail());
        new_staff.setStaffPassword(staffRegisterRequest.getPassword());
        staffRepository.save(new_staff);
    }

    @Override
    public void loginStaff(StaffLoginRequest staffLoginRequest) {
        Staff staff = staffRepository.findByEmail(staffLoginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + staffLoginRequest.getEmail()));

        boolean correctPassword = staff.getStaffEmail().equals(staffLoginRequest.getEmail());

        if (!correctPassword) {
            throw new InvalidCredentialException("Invalid credentials!");
        }

    }

    @Override
    public List<Patient> fetchAllPatient() {
        List<Patient> patients = patientRepository.allPatients();
        return patients;
    }

    @Override
    public List<Physician> fetchAllPhysician() {
        List<Physician> physicians = doctorRepository.allPhysicians();
        return physicians;
    }

    @Override
    public List<Nurse> fetchAllNurse() {
        List<Nurse> nurses = nurseRepository.allNurses();
        return nurses;
    }


    public PatientResponse fetchPatientById(Integer id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("No Patient with given Id"));

        return PatientMapper.mapToDto(patient);
    }

    public Appointment getAppointmentById(Integer id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("No appointment with given Id"));
        return appointment;
    }

    public List<Appointment> getAllAppointmentsByPatientId(Integer id) {
        List<Appointment> appointments = appointmentRepository.getAppointmentsByPatientId(id)
                .stream()
                .toList();
        if (appointments.isEmpty()) {
            throw new AppointmentNotFoundException("No appointment with given PatientId");
        }
        return appointments;
    }

    @Override
    public List<TrainedInResponse> getByPhysicianId(Integer physicianId) {

        List<TrainedIn> list = trainedInRepository.findByPhysicianWithDetails(physicianId);

        if (list.isEmpty()) {
            throw new TrainedInNotFoundException("No training records found for given physician Id");
        }


        return list.stream().map(t ->
                    TrainedInResponse.builder()
                            .physicianId(t.getPhysician().getEmployeeId())
                            .physicianName(t.getPhysician().getName())
                            .procedureId(t.getProcedure().getCode())
                            // comment this if error
                            //.procedureName(t.getProcedure().getName())
                            .certificationDate(t.getCertificationDate())
                            .certificationExpires(t.getCertificationExpires())
                            .build()
            ).toList();

    }
}