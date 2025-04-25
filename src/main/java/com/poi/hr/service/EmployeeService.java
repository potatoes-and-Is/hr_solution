package com.poi.hr.service;


import com.poi.hr.domain.common.Role;
import com.poi.hr.domain.login.entity.DepPositionEmployee;
import com.poi.hr.domain.login.entity.Employee;
import com.poi.hr.dto.LoginEmployeeDto;
import com.poi.hr.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder encoder;

    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder encoder) {
        this.employeeRepository = employeeRepository;
        this.encoder = encoder;
    }

    //    @Transactional
//    public Integer regist(SignupDTO signupDTO) {
//
//        if (userRepository.existsByUserId(signupDTO.getUserId())) {
//            return null;
//        }
//
//        try {
//            User user = new User();
//            user.setUserId(signupDTO.getUserId());
//            user.setUserName(signupDTO.getUserName());
//            user.setPassword(encoder.encode(signupDTO.getUserPassword()));
//            user.setUserRole(UserRole.valueOf(signupDTO.getRole()));
//
//            User savedUser = userRepository.save(user);
//            return savedUser.getUserCode();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }

    public LoginEmployeeDto findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.map(u -> {
            Role role = null;
            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                break; // 첫 번째만 가져온다고 가정
            }

            return new LoginEmployeeDto(
                    u.getEmployeeNumber(),
                    u.getPassword(),
                    role
            );
        }).orElse(null);
    }

    public LoginEmployeeDto findByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findByEmployeeNumber(username);

        return employee.map(u -> {
            Role role = null;
            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                break; // 첫 번째만 가져온다고 가정
            }

            return new LoginEmployeeDto(
                    u.getEmployeeNumber(),
                    u.getPassword(),
                    role
            );
        }).orElse(null);
    }
}
