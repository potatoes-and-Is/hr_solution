package com.poi.hr.service;

import com.poi.hr.domain.employee.DepPositionEmployee;
import com.poi.hr.dto.DepartmentDto;
import com.poi.hr.repository.DepPositionEmployeeRepository;
import com.poi.hr.repository.DepartmentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private static final Logger logger = Logger.getLogger(DepartmentService.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentRepository departmentRepository;
    private final DepPositionEmployeeRepository depPositionEmployeeRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, DepPositionEmployeeRepository depPositionEmployeeRepository) {
        this.departmentRepository = departmentRepository;
        this.depPositionEmployeeRepository = depPositionEmployeeRepository;
    }

    // 부서 정보 가져오기
    public List<DepartmentDto> getDepartmentList() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(dept -> new DepartmentDto(
                        dept.getDeptId(),
                        dept.getDeptCode(),
                        dept.getDeptName(),
                        dept.getCreatedBy(),
                        dept.getUpdatedBy(),
                        dept.getParentDeptId() != null ? dept.getParentDeptId().getDeptId() : null
                ))
                .collect(Collectors.toList());
    }

    // 부서 트리 형태로
    public List<DepartmentDto> buildDeptTree(List<DepartmentDto> flatList) {
        Map<Integer, DepartmentDto> map = new HashMap<>();
        List<DepartmentDto> roots = new ArrayList<>();

        for (DepartmentDto dto : flatList) {
            map.put(dto.getDeptId(), dto);
        }

        for (DepartmentDto dto : flatList) {
            if (dto.getParentDeptId() == null) {
                roots.add(dto);
            } else {
                DepartmentDto parent = map.get(dto.getParentDeptId());
                if (parent != null) {
                    parent.getChildren().add(dto);
                }
            }
        }

        return roots;
    }

    // 부서별 직원리스트 불러오기
    public List<DepPositionEmployee> getEmployeesByDeptId(Integer deptId) {
        return depPositionEmployeeRepository.findByDeptId(deptId);
    }

    // 부서 등록하기
    public DepartmentDto addDepartment(DepartmentDto departmentDto){

        Optional<Department> findName = departmentRepository.findByDeptName(departmentDto.getDeptName());
        Optional<Department> findCode = departmentRepository.findByDeptCode(departmentDto.getDeptCode());

        if(findName.isPresent() || findCode.isPresent()){
            throw new IllegalArgumentException("이미 존재하는 부서입니다." + departmentDto.getDeptCode() + departmentDto.getDeptName());
        }

        Department department = new Department(departmentDto.getDeptName(), departmentDto.getDeptCode());


        if (departmentDto.getParentDeptId() != null) {
            Department parentDept = departmentRepository.findById(departmentDto.getParentDeptId())
                    .orElseThrow(() -> new IllegalArgumentException("상위 부서를 찾을 수 없습니다."));
            department.setParentDeptId(parentDept);
        }

        Department saveDepartment = departmentRepository.save(department);

        return new DepartmentDto(saveDepartment.getDeptName(), saveDepartment.getDeptCode());
    }
}

