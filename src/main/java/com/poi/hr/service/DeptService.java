package com.poi.hr.service;

import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.employee.DepPositionEmployee;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.repository.DepPositionEmployeeRepository;
import com.poi.hr.repository.DeptRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DeptService {

    private static final Logger logger = Logger.getLogger(DeptService.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DeptService.class);

    private final DeptRepository deptRepository;
    private final DepPositionEmployeeRepository depPositionEmployeeRepository;


    @Autowired
    public DeptService(DeptRepository deptRepository, DepPositionEmployeeRepository depPositionEmployeeRepository) {
        this.deptRepository = deptRepository;
        this.depPositionEmployeeRepository = depPositionEmployeeRepository;
    }

    // 부서 정보 가져오기
    public List<DeptDTO> getDepartmentList() {
        List<Dept> departments = deptRepository.findAll();

        return departments.stream()
                .map(dept -> new DeptDTO(
                        dept.getDeptId(),
                        dept.getDeptCode(),
                        dept.getDeptName(),
                        dept.getCreatedBy(),
                        dept.getUpdatedBy(),
                        dept.getParentDept() != null ? dept.getParentDept().getDeptId() : null
                ))
                .collect(Collectors.toList());
    }

    // 부서 트리 형태로
    public List<DeptDTO> buildDeptTree(List<DeptDTO> flatList) {
        Map<Integer, DeptDTO> map = new HashMap<>();
        List<DeptDTO> roots = new ArrayList<>();

        for (DeptDTO dto : flatList) {
            map.put(dto.getDeptId(), dto);
        }

        for (DeptDTO dto : flatList) {
            if (dto.getParentDeptId() == null) {
                roots.add(dto);
            } else {
                DeptDTO parent = map.get(dto.getParentDeptId());
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
    public DeptDTO addDepartment(DeptDTO departmentDto){

        Optional<Dept> findName = deptRepository.findByDeptName(departmentDto.getDeptName());
        Optional<Dept> findCode = deptRepository.findByDeptCode(departmentDto.getDeptCode());


        if(findName.isPresent() || findCode.isPresent()){
            throw new IllegalArgumentException("이미 존재하는 부서입니다." + departmentDto.getDeptCode() + departmentDto.getDeptName());
        }

        Dept department = new Dept(departmentDto.getDeptCode(), departmentDto.getDeptName());
        department.setCreatedBy("SYSTEM");
        department.setUpdatedBy("SYSTEM");


        if (departmentDto.getParentDeptId() != null) {
            Dept parentDept = deptRepository.findById(departmentDto.getParentDeptId())
                    .orElseThrow(() -> new IllegalArgumentException("상위 부서를 찾을 수 없습니다."));
            department.setParentDept(parentDept);
        }

        Dept saveDepartment = deptRepository.save(department);

        return new DeptDTO(saveDepartment.getDeptName(), saveDepartment.getDeptCode());

    }

    // 부서 수정하기
    public DeptDTO updateDept(Integer deptId, String deptName) {

        Dept dept = deptRepository.findById(deptId)
                .orElseThrow(() -> new IllegalArgumentException("수정할 부서가 존재하지 않습니다."));

        Optional<Dept> findDept = deptRepository.findByDeptName(deptName);
        if(findDept.isPresent()) {
            throw new IllegalArgumentException("이미 사용중인 부서명입니다.");
        }

        dept.setDeptName(deptName);
        Dept saveDept = deptRepository.save(dept);

        return new DeptDTO(saveDept.getDeptId(), saveDept.getDeptCode(), saveDept.getDeptName());
    }

    // 부서 삭제하기
    public void deleteDept(int deptId){

        boolean result = deptRepository.existsById(deptId);

        if(!result) {
            throw new IllegalArgumentException("부서가 존재하지 않습니다." + deptId);
        }
        deptRepository.deleteById(deptId);
    }
}