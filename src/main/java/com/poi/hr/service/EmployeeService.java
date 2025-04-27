package com.poi.hr.service;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;



    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public List<Employee> findAllEmployees() {
        // Custom Repository 메서드 호출로 변경
        List<Employee> employees = employeeRepository.findAllEmployeesWithDetails();

        System.out.println(employees);
        return employees;
    }

    @Transactional
    public Employee save(Employee employee) {
        // 1. Employee 기본 정보 저장
        Employee savedEmp = employeeRepository.save(employee);

        // ✅ 기존 방식으로 반환 (employeeRepository 재호출)
        return employeeRepository.save(employee);
    }

    public void applyDefaultValues(Employee employee) {
        if (employee.getLevel() == 0) {
            employee.setLevel(1);
        }
    }
}
