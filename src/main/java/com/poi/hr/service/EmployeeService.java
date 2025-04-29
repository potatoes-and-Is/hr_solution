package com.poi.hr.service;


import com.poi.hr.domain.common.Role;
import com.poi.hr.domain.login.entity.DepPositionEmployee;
import com.poi.hr.domain.login.entity.Employee;
import com.poi.hr.domain.login.entity.TeamPositionPermission;
import com.poi.hr.dto.LoginEmployeeDto;
import com.poi.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final PasswordEncoder encoder;

    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder encoder) {
        this.employeeRepository = employeeRepository;
        this.encoder = encoder;
    }

    public void encryptAllPasswords() {
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees) {
            // 현재 비밀번호를 가져와서 암호화
            String rawPassword = employee.getPassword();
            String encodedPassword = encoder.encode(rawPassword);

            // 암호화된 비밀번호로 업데이트
            employee.setPassword(encodedPassword);
            employeeRepository.save(employee);
        }
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
    @Transactional(readOnly = true)
    public LoginEmployeeDto findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.map(u -> {
            Role role = null;
            List<TeamPositionPermission> permissions = null;
            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                break; // 첫 번째만 가져온다고 가정
            }

            return new LoginEmployeeDto(
                    u.getEmployeeId(),
                    u.getEmployeeName(),
                    u.getEmployeeNumber(),
                    u.getPassword(),
                    role,
                    permissions
            );
        }).orElse(null);
    }

    @Transactional(readOnly = true)
    public LoginEmployeeDto findByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findByEmployeeNumber(username);

        return employee.map(u -> {
            Role role = null;
            List<TeamPositionPermission> permissions = null;

            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                permissions = dpe.getTeamPosition().getPermissions(); // 권한 리스트 가져오기
                permissions.size();
                break; // 직책 첫 번째만 가져온다고 가정
            }

            return new LoginEmployeeDto(
                    u.getEmployeeId(),
                    u.getEmployeeName(),
                    u.getEmployeeNumber(),
                    u.getPassword(),
                    role,
                    permissions
            );
        }).orElse(null);
    }
}
