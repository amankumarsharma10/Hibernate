package com.hibernate.dao;

import com.hibernate.persistance.Department;
import com.hibernate.persistance.Employee;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by asharma on 30-11-2016.
 */
public class CRUDOperationImp implements CRUDOperation {

    public void save(Employee employee, Session session) {
        session.save(employee);
    }

    public List<Employee> getAllEmployees(Session session) {

        // ----- 1st Way-----
        //List<Employee> employeeList = session.createCriteria(Employee.class).list();

        // ----- 2nd Way-----
        List<Employee> employeeList = session.createQuery("from Employee").list();

        return employeeList;
    }

    public Employee getEmployee(int empId, Session session) {
        Employee employee = session.get(Employee.class,empId);
      /*  System.out.println("EMpId=> "+employee.getEmpId()+", Name=> "+employee.getFirstName() +", DepName=> "+employee.getDepartment().getDeptName()+", Role1=> "+employee.getRolesList().get(0).getRoleName()+", Role2=> "+employee.getRolesList().get(1).getRoleName());*/
        return employee;
    }

    public Department getDepartment(int deptId, Session session) {

        Department departments = session.get(Department.class,1);
        return departments;

    }
}
