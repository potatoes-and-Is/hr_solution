package com.poi.hr.service;

import com.poi.hr.domain.employee.*;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.dto.UpdateEmployeeDTO;
import com.poi.hr.dto.mapper.EmployeeMapper;
import com.poi.hr.repository.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        int nextNumber = employeeRepository.findNextEmployeeNumber(); // ⭐ 숫자만 가져옴
        String formattedEmployeeNumber = String.format("EMP" + "%03d", nextNumber); // 001, 002 형식
        employee.setEmployeeNumber(formattedEmployeeNumber); // DTO에 설정

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
    public void updateEmployee(int employeeId, UpdateEmployeeDTO updateData) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 직원이 없습니다: " + employeeId));

        // 1. 기본 정보 업데이트
        employee.setEmployeeName(updateData.getEmployeeName());
        employee.setEmail(updateData.getEmail());
        employee.setPhone(updateData.getPhone());
        employee.setAddress(updateData.getAddress());
        employee.setEmployeeIdentity(updateData.getEmployeeIdentity());
        employee.setPassword(updateData.getPassword());
        employee.setEmployeeStatus(updateData.getStatus()); // ⭐ 추가됨
        employee.setGender(updateData.getGender());

        // 2. 직급(Level) 변경
        if (updateData.getLevelId() != null) {
            Level level = levelRepository.findById(updateData.getLevelId())
                    .orElseThrow(() -> new RuntimeException("해당 ID의 직급이 없습니다: " + updateData.getLevelId()));
            employee.setLevel(level);
        }

        // 3. 부서/직책 변경 (DepPositionEmployee 테이블)
        DepPositionEmployee dpe = dpEmployeeRepository.findByEmployee(employee)
                .orElseThrow(() -> new RuntimeException("해당 직원의 부서-직책 연결이 없습니다: " + employeeId));

        if (updateData.getDeptId() != null) {
            Depts dept = deptsRepository.findById(updateData.getDeptId())
                    .orElseThrow(() -> new RuntimeException("해당 ID의 부서가 없습니다: " + updateData.getDeptId()));
            dpe.setDept(dept);
        }

        if (updateData.getPositionId() != null) {
            TeamPosition position = teamPositionRepository.findById(updateData.getPositionId())
                    .orElseThrow(() -> new RuntimeException("해당 ID의 직책이 없습니다: " + updateData.getPositionId()));
            dpe.setTeamPosition(position);
        }

        // 4. 저장
        employeeRepository.save(employee);
        dpEmployeeRepository.save(dpe);
    }


    // 상세 조회 서비스 메서드
    public EmployeeRequestDTO getEmployeeById(int employeeId) {
        // 직원 정보 조회 (직원 ID로 직원 정보를 가져오는 메서드)
        EmployeeRequestDTO employee = employeeRepository.getEmployeeDetail(employeeId);

        return employee;
    }
}