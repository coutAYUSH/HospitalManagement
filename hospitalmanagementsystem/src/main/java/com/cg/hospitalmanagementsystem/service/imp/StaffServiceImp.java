package com.cg.hospitalmanagementsystem.service.imp;

import com.cg.hospitalmanagementsystem.dto.request.StaffLoginRequest;
import com.cg.hospitalmanagementsystem.dto.request.StaffRegisterRequest;
import com.cg.hospitalmanagementsystem.entity.Nurse;
import com.cg.hospitalmanagementsystem.entity.Patient;
import com.cg.hospitalmanagementsystem.entity.Physician;
import com.cg.hospitalmanagementsystem.entity.Staff;
import com.cg.hospitalmanagementsystem.exception.InvalidCredentialException;
import com.cg.hospitalmanagementsystem.exception.UserNotFoundException;
import com.cg.hospitalmanagementsystem.reposistory.DoctorRepository;
import com.cg.hospitalmanagementsystem.reposistory.NurseRepository;
import com.cg.hospitalmanagementsystem.reposistory.PatientRepository;
import com.cg.hospitalmanagementsystem.reposistory.StaffRepository;
import com.cg.hospitalmanagementsystem.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImp implements StaffService {

    private final StaffRepository staffRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;

    public StaffServiceImp(StaffRepository staffRepository, PatientRepository patientRepository
            ,DoctorRepository doctorRepository, NurseRepository nurseRepository){
        this.staffRepository = staffRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
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
                .orElseThrow(()-> new UserNotFoundException("User not found with email: "+ staffLoginRequest.getEmail()));

        boolean correctPassword = staff.getStaffEmail().equals(staffLoginRequest.getEmail());

        if(!correctPassword){
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


}
