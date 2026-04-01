package com.cg.hospitalmanagementsystem.mappers;

import com.cg.hospitalmanagementsystem.entity.*;
import com.cg.hospitalmanagementsystem.entity.id.TrainedInId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrainedInMapper {


    public TrainedInResponseDTO toDto(TrainedIn entity) {

        TrainedInResponseDTO dto = new TrainedInResponseDTO();

        if (entity.getPhysician() != null) {
            dto.setPhysicianName(entity.getPhysician().getName());
        }

        if (entity.getProcedures() != null) {
            dto.setProcedureName(entity.getProcedures().getName());
        }

        dto.setCertificationDate(entity.getCertificationDate());
        dto.setCertificationExpires(entity.getCertificationExpires());

        return dto;
    }


    public TrainedIn toEntity(TrainedInRequestDTO dto,
                              Physician physician,
                              Procedures procedures) {

        TrainedInId id = new TrainedInId(
                physician.getEmployeeId(),
                procedures.getCode()
        );

        return TrainedIn.builder()
                .id(id)
                .physician(physician)
                .procedures(procedures)
                .certificationDate(dto.getCertificationDate())
                .certificationExpires(dto.getCertificationExpires())
                .build();
    }
}
