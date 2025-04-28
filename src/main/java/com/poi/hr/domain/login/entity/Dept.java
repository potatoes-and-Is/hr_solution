package com.poi.hr.domain.login.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Depts")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "dept_code", nullable = false, length = 30)
    private String deptCode;

    @Column(name = "dept_name", nullable = false, length = 30)
    private String deptName;

    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 30)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    //상위 부서 (parent_dept_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_dept_id")
    private Dept parentDept;

    //하위 부서 (양방향 관계 맺기 | self-join 시 필수)
    @OneToMany(mappedBy = "parentDept", fetch = FetchType.LAZY)
    private List<Dept> childDepts = new ArrayList<>();
    /*
    - 상위 부서로부터 하위 부서 목록 쭉 가져오기 가능하도록 선언
    - ArrayList를 new로 생성한 건 NullPointerException 막으려고 하는 습관
      (JPA가 나중에 채워주긴 하지만 기본값을 세팅하는 것)
    */

    public Dept() {

    }

    public Dept(String deptCode, String deptName, String createdBy, String updatedBy, Dept parentDept) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.parentDept = parentDept;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Dept getParentDept() {
        return parentDept;
    }

    public List<Dept> getChildDepts() {
        return childDepts;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setParentDept(Dept parentDept) {
        this.parentDept = parentDept;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", parentDept=" + parentDept +
                '}';
    }
    /*
    toString() 안에 childDepts 를 넣으면 무한루프가 생겨서 넣지 않음
    - toString() 은 객체 안에 필드 값을 문자열(String)으로 보여주는 메서드임
    - List<Dept> childDepts = new ArrayList<>();에서 childDepts 는 Dept 타입의 자식 객체들을 갖고 있음
    - childDepts(자식1, 자식2) 를 toString()에서 각각 자식1, 자식2 각각에 대해 또 toString() 호출
    - 자식1은 부모를 필드로 갖고 있기에, 다시 자신을 호출한 부모의 toString() 을 호출하고
    - 또 그 부모는 다시 자식의 toString() 을 호출하고.. 무한 반복!
      (필드가 기본 타입이면 그냥 값만 찍고 끝이지만, 필드가 객체 타입인 경우 그 객체의 toString()까지 호출하니까!)

    => 필드 중 객체 타입 필드는 조심해서 다루자, 무조건 다 toString() 으로 찍지 말자!
     */
}
