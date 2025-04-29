package com.poi.hr.service;

import com.poi.hr.domain.employee.*;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.dto.ResponseAuthorDTO;
import com.poi.hr.dto.UpdateEmployeeDTO;
import com.poi.hr.dto.mapper.EmployeeMapper;
import com.poi.hr.repository.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private final DPEmployeeRepository dpEmployeeRepository;
    private final DeptsRepository deptsRepository;
    private final TeamPositionRepository teamPositionRepository;
    private final LevelRepository levelRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, DPEmployeeRepository dpEmployeeRepository, DeptsRepository deptsRepository, TeamPositionRepository teamPositionRepository, LevelRepository levelRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.dpEmployeeRepository = dpEmployeeRepository;
        this.deptsRepository = deptsRepository;
        this.teamPositionRepository = teamPositionRepository;
        this.levelRepository = levelRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeRequestDTO> findAllEmployees() {
        // Custom Repository 메서드 호출로 변경
        List<EmployeeRequestDTO> employees = employeeRepository.findAllEmployeesWithDetails();

        System.out.println(employees);
        return employees;
    }

    @Transactional
    public Employee save(EmployeeRequestDTO employee) {

        Level level = levelRepository.findById(employee.getLevelId())
                .orElseThrow(() -> new NoSuchElementException("직급이 없습니다: ID=" + employee.getLevelId()));

        employee.setLevel(level);

        Employee savedEmp = employeeRepository.save(employeeMapper.toEntity(employee));

        Integer deptId = employee.getDeptId();
        Integer positionId = employee.getPositionId();

        if (deptId == null || positionId == null) {
            throw new IllegalArgumentException("부서 ID와 직책 ID는 필수입니다.");
        }

        Depts dept = deptsRepository.findById(deptId)
                .orElseThrow(() -> new NoSuchElementException("부서를 찾을 수 없습니다. ID=" + deptId));

        TeamPosition position = teamPositionRepository.findById(positionId)
                .orElseThrow(() -> new NoSuchElementException("직책을 찾을 수 없습니다. ID=" + positionId));

        DepPositionEmployee dpe = new DepPositionEmployee(position, dept, savedEmp);
        dpEmployeeRepository.save(dpe);

        return savedEmp;
    }


    @Transactional
    public Employee updateEmployee(int employeeId, UpdateEmployeeDTO updateData) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 직원이 없습니다: " + employeeId));

        existingEmployee.setEmployeeName(updateData.getEmployeeName());
        existingEmployee.setAddress(updateData.getAddress());
        existingEmployee.setEmail(updateData.getEmail());
        existingEmployee.setPassword(updateData.getPassword());
        existingEmployee.setEmployeeIdentity(updateData.getEmployeeIdentity());
        existingEmployee.setPhone(updateData.getPhone());

        return employeeRepository.save(existingEmployee);
    }

    // 상세 조회 서비스 메서드
    public EmployeeRequestDTO getEmployeeById(int employeeId) {
        // 직원 정보 조회 (직원 ID로 직원 정보를 가져오는 메서드)
        EmployeeRequestDTO employee = employeeRepository.getEmployeeDetail(employeeId);

        return employee;
        // DTO로 변환하여 반환
//        return new ResponseAuthorDTO(
//                employee.getEmployeeId(),
//                employee.getEmployeeNumber(),
//                employee.getEmployeeName(),
//                employee.getGender(),
//                employee.getAddress(),
//                employee.getEmail(),
//                employee.getPhone(),
//                employee.getEmployeeIdentity(),
//                employee.getEmployeeStatus(),
//                employee.getHireDate().toString(), // 날짜를 문자열로 변환
//                employee.getRetireDate() != null ? employee.getRetireDate().toString() : null, // null 체크 후 날짜를 문자열로 변환
//                employee.getDeptName(),
//                employee.getPositionName(),
//                employee.getLevelName(),
//                employee.getPassword(),
//                employee.getLevelId()
//        );
    }
}