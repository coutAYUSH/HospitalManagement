package com.cg.hospitalmanagementsystem.controllerTest;

import com.cg.hospitalmanagementsystem.controller.StaffController;
import com.cg.hospitalmanagementsystem.dto.response.ProcedureResponse;
import com.cg.hospitalmanagementsystem.service.imp.ProcedureServiceImp;
import com.cg.hospitalmanagementsystem.service.imp.StaffServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StaffController.class)
class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StaffServiceImp staffServiceImp;

    @MockBean
    private ProcedureServiceImp procedureServiceImp;

    @Test
    void testGetAllProcedures() throws Exception {


        ProcedureResponse p1 = ProcedureResponse.builder()
                .code(101)
                .name("X-Ray")
                .cost(500.0)
                .build();

        ProcedureResponse p2 = ProcedureResponse.builder()
                .code(102)
                .name("MRI")
                .cost(2500.0)
                .build();

        when(procedureServiceImp.getAllProcedures())
                .thenReturn(List.of(p1, p2));


        mockMvc.perform(get("/staff/procedure/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].code").value(101))
                .andExpect(jsonPath("$[0].name").value("X-Ray"))
                .andExpect(jsonPath("$[0].cost").value(500.0))
                .andExpect(jsonPath("$[1].code").value(102))
                .andExpect(jsonPath("$[1].name").value("MRI"))
                .andExpect(jsonPath("$[1].cost").value(2500.0));
    }
}