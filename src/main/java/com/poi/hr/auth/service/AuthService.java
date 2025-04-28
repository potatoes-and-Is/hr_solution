package com.poi.hr.auth.service;

import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.dto.LoginEmployeeDto;
import com.poi.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    private final EmployeeService employeeService;

    @Autowired
    public AuthService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginEmployeeDto login = employeeService.findByUsername(username);

        if (Objects.isNull(login)) {
            throw new UsernameNotFoundException("사원정보가 존재하지 않습니다.");
        }

        return new AuthDetails(login);
    }
}
