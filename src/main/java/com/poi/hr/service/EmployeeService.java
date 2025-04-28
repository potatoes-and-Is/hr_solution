package com.poi.hr.service;

import com.poi.hr.domain.employee.DPEmployee;
import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.EmployeeUpdateDTO;
import com.poi.hr.repository.DPEmployeeRepository;
import com.poi.hr.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private final DPEmployeeRepository dpEmployeeRepository;



    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DPEmployeeRepository dpEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.dpEmployeeRepository = dpEmployeeRepository;
    }

    public List<Employee> findAllEmployees() {
        // Custom Repository 메서드 호출로 변경
        List<Employee> employees = employeeRepository.findAllEmployeesWithDetails();

        System.out.println(employees);
        return employees;
    }

    @Transactional
    public Employee save(Employee employee) {
        // 1. 직원 기본 정보 저장
        Employee savedEmp = employeeRepository.save(employee);

        // 2. 프론트에서 전달받은 deptId, positionId 사용
        Integer deptId = employee.getDeptId();
        Integer positionId = employee.getPositionId();

        if (deptId == null || positionId == null) {
            throw new IllegalArgumentException("부서 ID와 직책 ID는 필수입니다.");
        }

        // 3. DPE 테이블 저장
        DPEmployee dpe = new DPEmployee(
                savedEmp.getEmployeeId(),
                deptId,
                positionId
        );
        dpEmployeeRepository.save(dpe);

        return savedEmp;
    }
    @Transactional
    public Employee updateEmployee(int employeeId, Employee updateData) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 직원이 없습니다: " + employeeId));

        // 필요한 필드만 업데이트
        existingEmployee.setName(updateData.getName());
        existingEmployee.setAddress(updateData.getAddress());
        existingEmployee.setEmail(updateData.getEmail());
        existingEmployee.setPassword(updateData.getPassword());
        existingEmployee.setIdentity(updateData.getIdentity());
        existingEmployee.setPhone(updateData.getPhone());

        return employeeRepository.save(existingEmployee);
    }

//    public void applyDefaultValues(Employee employee) {
//        if (employee.getLevel() == 0) {
//            employee.setLevel(1);
//        }
//    }
}
