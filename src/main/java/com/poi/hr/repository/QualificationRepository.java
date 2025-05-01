package com.poi.hr.repository;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findByEmployeeEmployeeId(int employeeId);
    void deleteAllByEmployee(Employee employee);
}


