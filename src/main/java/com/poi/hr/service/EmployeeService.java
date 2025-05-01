package com.poi.hr.service;
import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.employee.DepPositionEmployee;
import com.poi.hr.domain.hr.Level;
import com.poi.hr.domain.hr.TeamPosition;
import com.poi.hr.domain.vacation.*;
import com.poi.hr.domain.vacation.enums.TeamPositionRole;
import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.*;
import com.poi.hr.dto.mapper.EmployeeMapper;
import com.poi.hr.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private final DPEmployeeAPIRepository dpEmployeeAPIRepository;
    private final DeptAPIRepository deptAPIRepository;
    private final TeamPositionAPIRepository teamPositionAPIRepository;
    private final LevelAPIRepository levelAPIRepository;
    private final CareerRepository careerRepository;
    private final EducationRepository educationRepository;
    private final LanguageRepository languageRepository;
    private final QualificationRepository qualificationRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    private final PasswordEncoder encoder;

    public EmployeeService(EmployeeRepository employeeRepository, DPEmployeeAPIRepository dpEmployeeAPIRepository, DeptAPIRepository deptAPIRepository, TeamPositionAPIRepository teamPositionAPIRepository, LevelAPIRepository levelAPIRepository, CareerRepository careerRepository, EducationRepository educationRepository, LanguageRepository languageRepository, QualificationRepository qualificationRepository, EmployeeMapper employeeMapper, PasswordEncoder encoder) {
        this.employeeRepository = employeeRepository;
        this.dpEmployeeAPIRepository = dpEmployeeAPIRepository;
        this.deptAPIRepository = deptAPIRepository;
        this.teamPositionAPIRepository = teamPositionAPIRepository;
        this.levelAPIRepository = levelAPIRepository;
        this.careerRepository = careerRepository;
        this.educationRepository = educationRepository;
        this.languageRepository = languageRepository;
        this.qualificationRepository = qualificationRepository;
        this.employeeMapper = employeeMapper;
        this.encoder = encoder;
    }

    public List<EmployeeRequestDTO> findAllEmployees() {
        // Custom Repository 메서드 호출로 변경
        List<EmployeeRequestDTO> employees = employeeRepository.findAllEmployeesWithDetails();

        System.out.println(employees);
        return employees;
    }

    @Transactional
    public Employee save(EmployeeRequestDTO employee) {

        // 1. 직급 정보 조회
        Level level = levelAPIRepository.findById(employee.getLevelId())
                .orElseThrow(() -> new NoSuchElementException("직급이 없습니다: ID=" + employee.getLevelId()));

        // 2. 입사일 기본값
        if (employee.getHireDate() == null) {
            employee.setHireDate(LocalDate.now());
        }

        // 3. 사번 생성
        int nextNumber = employeeRepository.findNextEmployeeNumber();
        String formattedNumber = String.format("EMP%03d", nextNumber);
        employee.setEmployeeNumber(formattedNumber);

        // 4. 사원 저장
        Employee savedEmp = employeeRepository.save(employeeMapper.toEntity(employee, level));

        // 5. 부서-직책 관계 저장
        Integer deptId = employee.getDeptId();
        Integer positionId = employee.getPositionId();

        if (deptId == null || positionId == null) {
            throw new IllegalArgumentException("부서 ID와 직책 ID는 필수입니다.");
        }

        Dept dept = deptAPIRepository.findById(deptId)
                .orElseThrow(() -> new NoSuchElementException("부서를 찾을 수 없습니다. ID=" + deptId));
        TeamPosition position = teamPositionAPIRepository.findById(positionId)
                .orElseThrow(() -> new NoSuchElementException("직책을 찾을 수 없습니다. ID=" + positionId));

        dpEmployeeAPIRepository.save(new DepPositionEmployee(dept, savedEmp, position));

        // 6. 경력 저장
        if (employee.getCareers() != null) {
            employee.getCareers().forEach(dto -> {
                Career career = new Career();
                career.setPreviousCompany(dto.getPreviousCompany());
                career.setPreviousDeptName(dto.getPreviousDeptName());
                career.setPreviousLevel(dto.getPreviousLevel());
                career.setRetireReason(dto.getRetireReason());
                career.setCreatedBy(dto.getCreatedBy());
                career.setEmployee(savedEmp);
                careerRepository.save(career);
            });
        }

        // 7. 학력 저장
        if (employee.getEducations() != null) {
            employee.getEducations().forEach(dto -> {
                Education education = new Education();
                education.setSchoolName(dto.getSchoolName());
                education.setEntranceDate(dto.getEntranceDate());
                education.setGraduationDate(dto.getGraduationDate());
                education.setGraduationStatus(dto.getGraduationStatus());
                education.setCreatedBy(dto.getCreatedBy() != null ? dto.getCreatedBy() : "admin");
                System.out.println("교육 createdBy: " + dto.getCreatedBy());
                education.setEmployee(savedEmp);
                educationRepository.save(education);
            });
        }

        // 8. 자격증 저장
        if (employee.getQualifications() != null) {
            employee.getQualifications().forEach(dto -> {
                Qualification q = new Qualification();
                q.setQualificationName(dto.getQualificationName());
                q.setCertificateOrg(dto.getCertificateOrg());
                q.setCertificateDate(dto.getCertificateDate());
                q.setExpirationDate(dto.getExpirationDate());
                q.setCreatedBy(dto.getCreatedBy());
                q.setEmployee(savedEmp);
                qualificationRepository.save(q);
            });
        }

        // 9. 어학 저장
        if (employee.getLanguages() != null) {
            employee.getLanguages().forEach(dto -> {
                Language l = new Language();
                l.setLanguageName(dto.getLanguageName());
                l.setScore(dto.getScore());
                l.setLanguageOrg(dto.getLanguageOrg());
                l.setAcquisitionDate(dto.getAcquisitionDate());
                l.setExpirationDate(dto.getExpirationDate());
                l.setCreatedBy(dto.getCreatedBy());
                l.setEmployee(savedEmp);
                languageRepository.save(l);
            });
        }

        return savedEmp;
    }

    @Transactional
    public void updateEmployee(int employeeId, UpdateEmployeeDTO updateData) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 직원이 없습니다: " + employeeId));

        // 기본 정보
        employee.setEmployeeName(updateData.getEmployeeName());
        employee.setEmail(updateData.getEmail());
        employee.setPhone(updateData.getPhone());
        employee.setAddress(updateData.getAddress());
        employee.setEmployeeIdentity(updateData.getEmployeeIdentity());
        employee.setPassword(updateData.getPassword());
        employee.setEmployeeStatus(updateData.getEmployeeStatus());
        employee.setGender(updateData.getGender());

        // 직급 변경
        if (updateData.getLevelId() != null) {
            Level level = levelAPIRepository.findById(updateData.getLevelId())
                    .orElseThrow(() -> new RuntimeException("직급 없음: ID=" + updateData.getLevelId()));
            employee.setLevel(level);
        }

        // 부서-직책 연결
        DepPositionEmployee dpe = dpEmployeeAPIRepository.findByEmployee(employee)
                .orElseThrow(() -> new RuntimeException("부서-직책 연결 없음: " + employeeId));

        if (updateData.getDeptId() != null) {
            Dept dept = deptAPIRepository.findById(updateData.getDeptId())
                    .orElseThrow(() -> new RuntimeException("부서 없음: ID=" + updateData.getDeptId()));
            dpe.setDept(dept);
        }

        if (updateData.getPositionId() != null) {
            TeamPosition pos = teamPositionAPIRepository.findById(updateData.getPositionId())
                    .orElseThrow(() -> new RuntimeException("직책 없음: ID=" + updateData.getPositionId()));
            dpe.setTeamPosition(pos);
        }

        // ✅ 경력 수정 (기존 전체 삭제 후 재저장 방식 추천)
        careerRepository.deleteAllByEmployee(employee);
        if (updateData.getCareers() != null) {
            for (CareerDTO dto : updateData.getCareers()) {
                Career c = new Career();
                c.setPreviousCompany(dto.getPreviousCompany());
                c.setPreviousDeptName(dto.getPreviousDeptName());
                c.setPreviousLevel(dto.getPreviousLevel());
                c.setRetireReason(dto.getRetireReason());
                c.setCreatedBy(dto.getCreatedBy()!= null ? dto.getCreatedBy() : "admin");
                c.setEmployee(employee);
                careerRepository.save(c);
            }
        }

        // ✅ 학력 수정
        educationRepository.deleteAllByEmployee(employee);
        if (updateData.getEducations() != null) {
            for (EducationDTO dto : updateData.getEducations()) {
                Education edu = new Education();
                edu.setSchoolName(dto.getSchoolName());
                edu.setEntranceDate(dto.getEntranceDate());
                edu.setGraduationDate(dto.getGraduationDate());
                edu.setGraduationStatus(dto.getGraduationStatus());
                edu.setCreatedBy(dto.getCreatedBy()!= null ? dto.getCreatedBy() : "admin");
                edu.setEmployee(employee);
                educationRepository.save(edu);
            }
        }

        // ✅ 자격증 수정
        qualificationRepository.deleteAllByEmployee(employee);
        if (updateData.getQualifications() != null) {
            for (QualificationDTO dto : updateData.getQualifications()) {
                Qualification q = new Qualification();
                q.setQualificationName(dto.getQualificationName());
                q.setCertificateOrg(dto.getCertificateOrg());
                q.setCertificateDate(dto.getCertificateDate());
                q.setExpirationDate(dto.getExpirationDate());
                q.setCreatedBy(dto.getCreatedBy()!= null ? dto.getCreatedBy() : "admin");
                q.setEmployee(employee);
                qualificationRepository.save(q);
            }
        }

        // ✅ 어학 수정
        languageRepository.deleteAllByEmployee(employee);
        if (updateData.getLanguages() != null) {
            for (LanguageDTO dto : updateData.getLanguages()) {
                Language l = new Language();
                l.setLanguageName(dto.getLanguageName());
                l.setScore(dto.getScore());
                l.setLanguageOrg(dto.getLanguageOrg());
                l.setAcquisitionDate(dto.getAcquisitionDate());
                l.setExpirationDate(dto.getExpirationDate());
                l.setCreatedBy(dto.getCreatedBy()!= null ? dto.getCreatedBy() : "admin");
                l.setEmployee(employee);
                languageRepository.save(l);
            }
        }

        // 저장
        employeeRepository.save(employee);
        dpEmployeeAPIRepository.save(dpe);
    }


    // 상세 조회 서비스 메서드
    public EmployeeRequestDTO getEmployeeById(int employeeId) {
        // 직원 정보 조회
        EmployeeRequestDTO employee = employeeRepository.getEmployeeDetail(employeeId);


        if (employee == null) {
            throw new NoSuchElementException("해당 ID의 직원 정보가 없습니다: " + employeeId);
        }

        // 경력, 학력, 자격증, 어학 정보를 EmployeeRequestDTO에 포함시켜서 반환
        List<CareerDTO> careers = careerRepository.findByEmployeeEmployeeId(employeeId).stream()
                .map(career -> new CareerDTO(career.getPreviousCompany(), career.getPreviousDeptName(), career.getPreviousLevel(), career.getRetireReason(), career.getCreatedBy()))
                .collect(Collectors.toList());
        employee.setCareers(careers);

        List<EducationDTO> educations = educationRepository.findByEmployeeEmployeeId(employeeId).stream()
                .map(education -> new EducationDTO(education.getSchoolName(), education.getEntranceDate(), education.getGraduationDate(), education.getGraduationStatus(), education.getCreatedBy()))
                .collect(Collectors.toList());
        employee.setEducations(educations);

        List<QualificationDTO> qualifications = qualificationRepository.findByEmployeeEmployeeId(employeeId).stream()
                .map(qualification -> new QualificationDTO(qualification.getQualificationName(), qualification.getCertificateOrg(), qualification.getCertificateDate(), qualification.getExpirationDate(), qualification.getCreatedBy()))
                .collect(Collectors.toList());
        employee.setQualifications(qualifications);

        List<LanguageDTO> languages = languageRepository.findByEmployeeEmployeeId(employeeId).stream()
                .map(language -> new LanguageDTO(language.getLanguageName(), language.getScore(), language.getLanguageOrg(), language.getAcquisitionDate(), language.getExpirationDate(), language.getCreatedBy()))
                .collect(Collectors.toList());
        employee.setLanguages(languages);

        return employee;
    }


    public void encryptAllPasswords() {
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees) {
            // 현재 비밀번호를 가져와서 암호화
            String rawPassword = employee.getPassword();
            String encodedPassword = encoder.encode(rawPassword);

            // 암호화된 비밀번호로 업데이트
            employee.setPassword(encodedPassword);
            employeeRepository.save(employee);
        }
    }

    @Transactional(readOnly = true)
    public LoginEmployeeDto findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.map(u -> {
            TeamPositionRole role = null;
            List<TeamPositionPermission> permissions = null;
            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                permissions = dpe.getTeamPosition().getPermissions(); // 권한 리스트 가져오기
                break; // 첫 번째만 가져온다고 가정
            }

            return new LoginEmployeeDto(
                    u.getEmployeeId(),
                    u.getEmployeeName(),
                    u.getEmployeeNumber(),
                    u.getPassword(),
                    role,
                    permissions
            );
        }).orElse(null);
    }

    @Transactional(readOnly = true)
    public LoginEmployeeDto findByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findByEmployeeNumber(username);

        return employee.map(u -> {
            TeamPositionRole role = null;
            List<TeamPositionPermission> permissions = null;

            for (DepPositionEmployee dpe : u.getDepPositionEmployees()) {
                role = dpe.getTeamPosition().getRole();
                permissions = dpe.getTeamPosition().getPermissions();
                permissions.size(); // 그냥 .size()만 호출해도 강제로 초기화됨!
                // 권한 리스트 가져오기
                break; // 직책 첫 번째만 가져온다고 가정
            }

            return new LoginEmployeeDto(
                    u.getEmployeeId(),
                    u.getEmployeeName(),
                    u.getEmployeeNumber(),
                    u.getPassword(),
                    role,
                    permissions
            );
        }).orElse(null);
    }
}
