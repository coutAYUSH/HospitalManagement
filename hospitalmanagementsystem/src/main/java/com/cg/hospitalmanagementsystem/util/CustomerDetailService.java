package com.cg.hospitalmanagementsystem.util;

import com.cg.hospitalmanagementsystem.entity.Staff;
import com.cg.hospitalmanagementsystem.exception.UserNotFoundException;
import com.cg.hospitalmanagementsystem.repository.StaffRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailService implements UserDetailsService {
    private final StaffRepository staffRepository;

    public CustomerDetailService(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return User.builder()
                .username(staff.getStaffEmail())
                .password(staff.getStaffPassword())
                .roles(staff.getRole())
                .build();
    }
}
