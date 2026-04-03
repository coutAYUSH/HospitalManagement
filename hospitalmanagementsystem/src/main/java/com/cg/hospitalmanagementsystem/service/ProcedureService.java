package com.cg.hospitalmanagementsystem.service;


import com.cg.hospitalmanagementsystem.dto.response.ProcedureResponse;

import java.util.List;

public interface ProcedureService {

    List<ProcedureResponse> getAllProcedures();

}
