package com.poi.hr.service.approval;

import com.poi.hr.domain.attendance.Attend;
import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.AttendanceFixReq;
import com.poi.hr.domain.vacation.DocType;
import com.poi.hr.dto.approval.ApprovalFixAttendSaveDTO;
import com.poi.hr.repository.AttendRepository;
import com.poi.hr.repository.EmployeeRepository;
import com.poi.hr.repository.approval.ApprovalRepository;
import com.poi.hr.repository.approval.AttendanceFixReqRepository;
import com.poi.hr.repository.approval.DocTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApprovalAttendanceFixReqService {

    private final ApprovalRepository approvalRepository;
    private final AttendanceFixReqRepository attendanceFixReqRepository;
    private final EmployeeRepository employeeRepository;
    private final DocTypeRepository docTypeRepository;
    private final AttendRepository attendRepository;

    public ApprovalAttendanceFixReqService(ApprovalRepository approvalRepository, AttendanceFixReqRepository attendanceFixReqRepository, EmployeeRepository employeeRepository, DocTypeRepository docTypeRepository,  AttendRepository attendRepository) {
        this.approvalRepository = approvalRepository;
        this.attendanceFixReqRepository = attendanceFixReqRepository;
        this.employeeRepository = employeeRepository;
        this.docTypeRepository = docTypeRepository;
        this.attendRepository = attendRepository;
    }

    /* 출퇴근정정 문서 저장 */
    @Transactional
    public void saveAttendanceFixReq(ApprovalFixAttendSaveDTO approvalFixAttendSaveDTO, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        DocType docType = docTypeRepository.findByDocTypeCode(approvalFixAttendSaveDTO.getDocTypeCode());
        Attend attend = attendRepository.findById(approvalFixAttendSaveDTO.getAttendId()).orElse(null);

        AttendanceFixReq  attendanceFixReq = new AttendanceFixReq(
                employee,
                docType,
                attend,
                approvalFixAttendSaveDTO.getApprovalTitle(),
                approvalFixAttendSaveDTO.getApprovalContent(),
                approvalFixAttendSaveDTO.getApprovalReason(),
                approvalFixAttendSaveDTO.getNewCheckInTime(),
                approvalFixAttendSaveDTO.getNewCheckOutTime()
        );

        attendanceFixReqRepository.save(attendanceFixReq);

        approvalFixAttendSaveDTO.getApprovalLineList().get(0).setApprovalDocId(attendanceFixReq.getApprovalDocId());
    }

}
