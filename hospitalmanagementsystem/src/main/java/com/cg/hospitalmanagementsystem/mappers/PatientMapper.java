package com.cg.hospitalmanagementsystem.mappers;

import com.cg.hospitalmanagementsystem.dto.request.PatientRequestDTO;
import com.cg.hospitalmanagementsystem.dto.response.PatientResponseDTO;
import com.cg.hospitalmanagementsystem.entity.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Patient toEntity(PatientRequestDTO dto) {
        Patient patient = modelMapper.map(dto, Patient.class);

        if (dto.pcpId != null) {
            Physician physician = new Physician();
            physician.setEmployeeId(dto.pcpId);
            patient.setPrimaryCarePhysician(physician);
        }

        return patient;
    }

    public PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO dto = modelMapper.map(patient, PatientResponseDTO.class);

        if (patient.getPrimaryCarePhysician() != null) {
            dto.pcpId = patient.getPrimaryCarePhysician().getEmployeeId();
        }

        return dto;
    }
}
