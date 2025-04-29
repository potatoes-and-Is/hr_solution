package com.poi.hr.controller;

import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.employee.DepPositionEmployee;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.repository.DepPositionEmployeeRepository;
import com.poi.hr.repository.DeptRepository;
import com.poi.hr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
@Validated
public class DeptController {

    private static final Logger logger = Logger.getLogger(DeptController.class.getName());
    private final DeptService deptService;
    private final DepPositionEmployeeRepository depPositionEmployeeRepository;
    private final DeptRepository deptRepository;

    @Autowired
    public DeptController(DeptService deptService,
                          DepPositionEmployeeRepository depPositionEmployeeRepository, DeptRepository deptRepository) {
        this.deptService = deptService;
        this.depPositionEmployeeRepository = depPositionEmployeeRepository;
        this.deptRepository = deptRepository;
    }

    // 부서 리스트 트리 형태로 보여줌
    @GetMapping("/departmentInfo")
    public String departmentInfo(Model model) {
        List<DeptDTO> flatList = deptService.getDepartmentList();
        List<DeptDTO> deptTree = deptService.buildDeptTree(flatList);
        model.addAttribute("deptTree", deptTree);
        return "department/departmentInfo";
    }

    // 부서 리스트 데이터 넘겨줌
    @GetMapping("/department")
    public ResponseEntity<List<DeptDTO>> getAllDepartments() {
        List<DeptDTO> departmentList = deptService.getDepartmentList();
        return ResponseEntity.ok(departmentList);
    }


    // 특정 부서 소속된 직원 조회
    @ResponseBody
    @GetMapping("/department/{deptId}/employees")
    public List<EmployeeResponse> getEmployeesByDepartment(@PathVariable("deptId") Integer deptId) {
        List<DepPositionEmployee> dpeList = deptService.getEmployeesByDeptId(deptId);

        return dpeList.stream()
                .map(dpe -> new EmployeeResponse(
                        dpe.getEmployee().getEmployeeName(),
                        dpe.getEmployee().getEmployeeNumber(),
                        dpe.getTeamPosition().getPositionName()
                ))
                .collect(Collectors.toList());
    }

    public DepPositionEmployeeRepository getDepPositionEmployeeRepository() {
        return depPositionEmployeeRepository;
    }

    public DeptRepository getDeptRepository() {
        return deptRepository;
    }

    public record EmployeeResponse(String employeeName, String employeeNumber, String teamPositionName) {
    }

    // 부서 추가
    @PostMapping("/department/add")
    public ResponseEntity<DeptDTO> addDepartment(@Validated @RequestBody DeptDTO deptDTO) {

        DeptDTO saveDepartment = deptService.addDepartment(deptDTO);

        if(saveDepartment == null) {
            return ResponseEntity.status(500).body(null);
        } else {
            return ResponseEntity.ok().body(saveDepartment);
        }
    }

    // 부서 수정
    @PatchMapping("/department/update/{deptId}")
    public ResponseEntity<DeptDTO> updateDepartment(@PathVariable("deptId") int deptId, @Validated @RequestBody DeptDTO deptDTO) {

        DeptDTO updatedDept = deptService.updateDept(deptId, deptDTO.getDeptName());

        if (updatedDept == null) {
            return ResponseEntity.status(500).body(null);
        } else {
            return ResponseEntity.ok(updatedDept);
        }
    }

    // 부서 삭제
    @DeleteMapping("/department/delete/{deptId}")
    public ResponseEntity<DeptDTO> getDeptById(@PathVariable("deptId") int deptId){
        deptService.deleteDept(deptId);
        return ResponseEntity.noContent().build();
    }
}