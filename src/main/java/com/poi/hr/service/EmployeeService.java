package com.poi.hr.service;
import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.employee.DepPositionEmployee;
import com.poi.hr.domain.hr.Level;
import com.poi.hr.domain.hr.TeamPosition;
import com.poi.hr.domain.vacation.enums.TeamPositionRole;
import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.TeamPositionPermission;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.dto.LoginEmployeeDto;
import com.poi.hr.dto.UpdateEmployeeDTO;
import com.poi.hr.dto.mapper.EmployeeMapper;
import com.poi.hr.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private final DPEmployeeAPIRepository dpEmployeeAPIRepository;
    private final DeptAPIRepository deptAPIRepository;
    private final TeamPositionAPIRepository teamPositionAPIRepository;
    private final LevelAPIRepository levelAPIRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    private final PasswordEncoder encoder;

    public EmployeeService(EmployeeRepository employeeRepository, DPEmployeeAPIRepository dpEmployeeAPIRepository, DeptAPIRepository deptAPIRepository, TeamPositionAPIRepository teamPositionAPIRepository, LevelAPIRepository levelAPIRepository, EmployeeMapper employeeMapper, PasswordEncoder encoder) {
        this.employeeRepository = employeeRepository;
        this.dpEmployeeAPIRepository = dpEmployeeAPIRepository;
        this.deptAPIRepository = deptAPIRepository;
        this.teamPositionAPIRepository = teamPositionAPIRepository;
        this.levelAPIRepository = levelAPIRepository;
        this.employeeMapper = employeeMapper;
        this.encoder = encoder;
    }

    public List<EmployeeRequestDTO> findAllEmployees() {
        // Custom Repository 메서드 호출로 변경
        List<EmployeeRequestDTO> employees = employeeRepository.findAllEmployeesWithDetails();

        System.out.println(employees);
        return employees;
    }

    @jakarta.transaction.Transactional
    public Employee save(EmployeeRequestDTO employee) {

        Level level = levelAPIRepository.findById(employee.getLevelId())
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

        Dept dept = deptAPIRepository.findById(deptId)
                .orElseThrow(() -> new NoSuchElementException("부서를 찾을 수 없습니다. ID=" + deptId));

        TeamPosition position = teamPositionAPIRepository.findById(positionId)
                .orElseThrow(() -> new NoSuchElementException("직책을 찾을 수 없습니다. ID=" + positionId));

        DepPositionEmployee dpe = new DepPositionEmployee(dept, savedEmp, position);
        dpEmployeeAPIRepository.save(dpe);


        return savedEmp;
    }


    @jakarta.transaction.Transactional
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
            Level level = levelAPIRepository.findById(updateData.getLevelId())
                    .orElseThrow(() -> new RuntimeException("해당 ID의 직급이 없습니다: " + updateData.getLevelId()));
            employee.setLevel(level);
        }

        // 3. 부서/직책 변경 (DepPositionEmployee 테이블)
        DepPositionEmployee dpe = dpEmployeeAPIRepository.findByEmployee(employee)
                .orElseThrow(() -> new RuntimeException("해당 직원의 부서-직책 연결이 없습니다: " + employeeId));

        if (updateData.getDeptId() != null) {
            Dept dept = deptAPIRepository.findById(updateData.getDeptId())
                    .orElseThrow(() -> new RuntimeException("해당 ID의 부서가 없습니다: " + updateData.getDeptId()));
            dpe.setDept(dept);
        }

        if (updateData.getPositionId() != null) {
            TeamPosition position = teamPositionAPIRepository.findById(updateData.getPositionId())
                    .orElseThrow(() -> new RuntimeException("해당 ID의 직책이 없습니다: " + updateData.getPositionId()));
            dpe.setTeamPosition(position);
        }

        // 4. 저장
        employeeRepository.save(employee);
        dpEmployeeAPIRepository.save(dpe);
    }


    // 상세 조회 서비스 메서드
    public EmployeeRequestDTO getEmployeeById(int employeeId) {
        // 직원 정보 조회 (직원 ID로 직원 정보를 가져오는 메서드)
        EmployeeRequestDTO employee = employeeRepository.getEmployeeDetail(employeeId);

        return employee;
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

    @Transactional(readOnly = true)
    public LoginEmployeeDto findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.map(u -> {
            TeamPositionRole role = null;
            List<TeamPositionPermission> permissions = null;
            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                permissions = dpe.getTeamPosition().getPermissions(); // 권한 리스트 가져오기
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
            TeamPositionRole role = null;
            List<TeamPositionPermission> permissions = null;

            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                permissions = dpe.getTeamPosition().getPermissions();
                permissions.size(); // 그냥 .size()만 호출해도 강제로 초기화됨!
                // 권한 리스트 가져오기
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
