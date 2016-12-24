package com.hibernate.dao;

import com.hibernate.persistance.Department;
import com.hibernate.persistance.Employee;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by asharma on 30-11-2016.
 */
public interface CRUDOperation {
    public void save(Employee employee, Session session);
    public List<Employee> getAllEmployees(Session session);
    public Employee getEmployee(int empId, Session session);
    public Department getDepartment(int deptId, Session session);
}
