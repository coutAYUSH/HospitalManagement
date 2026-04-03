package com.cg.hospitalmanagementsystem.service;


import com.cg.hospitalmanagementsystem.dto.response.StayResponse;

import java.util.List;

public interface StayService {
    StayResponse getStayById(Integer id);
    List<StayResponse> getStaysByPatientId(Integer patientId);
}
