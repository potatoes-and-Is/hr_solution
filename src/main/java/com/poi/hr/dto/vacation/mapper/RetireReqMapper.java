package com.poi.hr.dto.vacation.mapper;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.DocType;
import com.poi.hr.domain.vacation.RetireReq;
import com.poi.hr.dto.vacation.ApprovalEmpRetireSaveDTO;

public class RetireReqMapper {

    public static RetireReq toEntity(ApprovalEmpRetireSaveDTO dto, Employee emp, DocType docType) {
        RetireReq entity = new RetireReq();
        entity.setEmployee(emp);
        entity.setDocType(docType);
        entity.setApprovalTitle(dto.getApprovalTitle());
        entity.setApprovalContent(dto.getApprovalContent());
        entity.setApprovalReason(dto.getApprovalReason());
        entity.setRetireDate(dto.getRetireDate());
        entity.setRetireType(dto.getRetireType());
        return entity;
    }

    public static ApprovalEmpRetireSaveDTO toDto(RetireReq entity) {
        ApprovalEmpRetireSaveDTO dto = new ApprovalEmpRetireSaveDTO();
        dto.setApprovalTitle(entity.getApprovalTitle());
        dto.setApprovalContent(entity.getApprovalContent());
        dto.setApprovalReason(entity.getApprovalReason());
        dto.setRetireDate(entity.getRetireDate());
        dto.setRetireType(entity.getRetireType());
        return dto;
    }
}

