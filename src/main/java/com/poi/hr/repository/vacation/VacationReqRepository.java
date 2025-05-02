package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.VacationReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationReqRepository extends JpaRepository<VacationReq, Integer> {

    @Query("SELECT r FROM VacationReq r WHERE r.employee.employeeId = :employeeId AND FUNCTION('YEAR', r.vacReqStartDate) = :year")
    List<VacationReq> findByEmployeeIdAndYear(@org.springframework.data.repository.query.Param("employeeId") Integer employeeId,
                                              @org.springframework.data.repository.query.Param("year") int year);

    VacationReq findByApprovalDocId(Integer approvalDocId);

    @Query(value = """
    SELECT 
        e.employee_name AS employeeName,
        v.vac_req_start_date AS startDate,
        v.vac_req_end_date AS endDate,
        vt.vac_type_name AS vacationType
    FROM vacation_reqs v
    JOIN approval_docs a ON v.approval_doc_id = a.approval_doc_id
    JOIN employees e ON a.employee_id = e.employee_id
    JOIN dep_position_employees dpe ON dpe.employee_id = e.employee_id
    JOIN depts d ON dpe.dept_id = d.dept_id
    JOIN vacation_types vt ON v.vac_type_id = vt.vac_type_id
    WHERE d.dept_id = :deptId
      AND a.approval_status = 'APPROVED'
""", nativeQuery = true)
    List<Object[]> findApprovedVacationsByDeptId(@Param("deptId") Integer deptId);
}
/* vacReqStart 기준으로 연도만 비교 */