package com.cg.hospitalmanagementsystem.service.imp;


import com.cg.hospitalmanagementsystem.dto.response.*;
import com.cg.hospitalmanagementsystem.entity.Stay;
import com.cg.hospitalmanagementsystem.repository.StayRepository;
import com.cg.hospitalmanagementsystem.service.StayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StayServiceImp implements StayService {

    private final StayRepository stayRepository;

    @Override
    public StayResponse getStayById(Integer id) {

        Stay stay = stayRepository.findByIdWithPatientAndRoom(id)
                .orElseThrow(() -> new RuntimeException("Stay not found"));

        // Map Patient -> PatientResponse
        PatientResponse patientResponse = PatientResponse.builder()
                .ssn(stay.getPatient().getSsn())
                .name(stay.getPatient().getName())
                .address(stay.getPatient().getAddress())
                .phone(stay.getPatient().getPhone())
                .insuranceId(stay.getPatient().getInsuranceId())
                .primaryCarePhysicianId(
                        stay.getPatient().getPrimaryCarePhysician().getEmployeeId()
                )
                .primaryCarePhysicianName(
                        stay.getPatient().getPrimaryCarePhysician().getName()
                )
                .build();

        // Final Response
        return StayResponse.builder()
                .stayId(stay.getStayId())
                .stayStart(stay.getStayStart())
                .stayEnd(stay.getStayEnd())
                .patient(patientResponse)
                .roomNumber(stay.getRoom().getRoomNumber())
                .build();
    }

    @Override
    public List<StayResponse> getStaysByPatientId(Integer patientId) {

        List<Stay> stays = stayRepository.findByPatientIdWithDetails(patientId);

        if (stays.isEmpty()) {
            throw new RuntimeException("No stays found for patient");
        }

        return stays.stream().map(stay -> {

            // Patient mapping
            PatientResponse patientResponse = PatientResponse.builder()
                    .ssn(stay.getPatient().getSsn())
                    .name(stay.getPatient().getName())
                    .address(stay.getPatient().getAddress())
                    .phone(stay.getPatient().getPhone())
                    .insuranceId(stay.getPatient().getInsuranceId())
                    .primaryCarePhysicianId(
                            stay.getPatient().getPrimaryCarePhysician().getEmployeeId()
                    )
                    .primaryCarePhysicianName(
                            stay.getPatient().getPrimaryCarePhysician().getName()
                    )
                    .build();

            return StayResponse.builder()
                    .stayId(stay.getStayId())
                    .stayStart(stay.getStayStart())
                    .stayEnd(stay.getStayEnd())
                    .patient(patientResponse)
                    .roomNumber(stay.getRoom().getRoomNumber())
                    .build();

        }).toList();
    }
}
