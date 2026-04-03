package com.cg.hospitalmanagementsystem.service.imp;

import com.cg.hospitalmanagementsystem.dto.request.StaffLoginRequest;
import com.cg.hospitalmanagementsystem.dto.response.LoginResponse;
import com.cg.hospitalmanagementsystem.entity.Staff;
import com.cg.hospitalmanagementsystem.repository.StaffRepository;
import com.cg.hospitalmanagementsystem.service.AuthService;
import com.cg.hospitalmanagementsystem.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    private final StaffRepository staffRepository;
    private final JwtUtil jwtUtil;

    public AuthServiceImp(StaffRepository staffRepository, JwtUtil jwtUtil){
        this.staffRepository = staffRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponse login(StaffLoginRequest loginRequest) {

        Staff staff = staffRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new RuntimeException("user not found"));

        if(!staff.getStaffPassword().equals(loginRequest.getPassword())){
            throw new RuntimeException("Invalid password ");
        }

        String role = staff.getRole();
        String token = jwtUtil.generateToken(staff.getStaffEmail(),role);

        String nextPage = determineNextPage(role);

        return new LoginResponse(token, role, nextPage, "Login successful");


    }


    private String determineNextPage(String role) {
        if (role == null) {
            return "/login";
        }

        return switch (role.toUpperCase()) {
            case "ADMIN" -> "/admin";
            case "DOCTOR" -> "/doctor";
            case "NURSE" -> "/nurse";
            default -> "/login";
        };
    }
}
