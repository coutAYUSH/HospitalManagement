package com.cg.hospitalmanagementsystem.mappers;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final ModelMapper modelMapper;

    public AppointmentResponseDTO toDto(Appointment appointment) {
        AppointmentResponseDTO dto =
                modelMapper.map(appointment, AppointmentResponseDTO.class);

        if (appointment.getPhysician() != null) {
            dto.setPhysicianName(appointment.getPhysician().getName());
        }

        if (appointment.getPrepNurse() != null) {
            dto.setNurseName(appointment.getPrepNurse().getName());
        }

        return dto;
    }


    public Appointment toEntity(AppointmentRequestDTO dto,
                                Physician physician,
                                Nurse nurse) {

        return Appointment.builder()
                .start(dto.getStart())
                .end(dto.getEnd())
                .examinationRoom(dto.getExaminationRoom())
                .physician(physician)
                .prepNurse(nurse)
                .build();
    }
}
