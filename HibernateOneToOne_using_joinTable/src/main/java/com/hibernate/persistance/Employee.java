package com.hibernate.persistance;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asharma on 29-11-2016.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    private String firstName,lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_department",joinColumns ={@JoinColumn(name = "employeeId",referencedColumnName = "empId")} ,inverseJoinColumns ={ @JoinColumn(name = "deptmentId",referencedColumnName = "deptId")})
    private Department department;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }
}
