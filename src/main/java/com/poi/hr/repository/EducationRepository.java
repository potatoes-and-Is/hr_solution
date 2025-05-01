package com.poi.hr.repository;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByEmployeeEmployeeId(int employeeId);
    void deleteAllByEmployee(Employee employee);
}


