package com.cg.hospitalmanagementsystem.service.imp;


import com.cg.hospitalmanagementsystem.dto.response.ProcedureResponse;
import com.cg.hospitalmanagementsystem.entity.Procedure;
import com.cg.hospitalmanagementsystem.reposistory.ProcedureRepository;
import com.cg.hospitalmanagementsystem.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImp implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    @Override
    public List<ProcedureResponse> getAllProcedures() {

        return procedureRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
       private ProcedureResponse mapToResponse(Procedure procedure) {
        return ProcedureResponse.builder()
                .code(procedure.getCode())
                .name(procedure.getName())
                .cost(procedure.getCost())
                .build();
    }
}
