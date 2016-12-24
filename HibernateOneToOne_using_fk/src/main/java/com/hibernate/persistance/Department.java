package com.hibernate.persistance;

import javax.persistence.*;

/**
 * Created by asharma on 30-11-2016.
 */
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String deptName;

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Employee employee;

    public Department() {
    }

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
