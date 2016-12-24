package com.hibernate;

import com.hibernate.persistance.Department;
import com.hibernate.persistance.Employee;
import com.hibernate.util.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by asharma on 01-12-2016.
 */
public class Demo {

    public static void main(String[] args) {
        Demo d= new Demo();
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
       // Demo d= new Demo();

        // SAVE
        d.save(sessionFactory);

        d.getDepartmant(sessionFactory);

        d.getEmployee(sessionFactory);

        sessionFactory.close();
    }
    private void getEmployee(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class,1);

        System.out.println();
        System.out.println("empName=>"+employee.getFirstName()+", deptName=>"+employee.getDepartment().getDeptName());
    }

    private void getDepartmant(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Department department = session.get(Department.class,1);

        System.out.println();
        System.out.println("deptId=>"+department.getDeptId()+", deptName=>"+department.getDeptName()+", empName=>"+ department.getEmployee().getFirstName());
    }

    private void save(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();

        Employee employee = new Employee();
        employee.setFirstName("Aman");
        employee.setLastName("Kumar");

        Employee employee1 = new Employee();
        employee1.setFirstName("Kamal");
        employee1.setLastName("Kumar");

        Department department = new Department();
        department.setDeptName("hr");;

        Department department1 = new Department();
        department1.setDeptName("ta");

        employee.setDepartment(department);
        employee1.setDepartment(department1);

        session.save(employee);
        session.save(employee1);
        session.beginTransaction().commit();
        session.close();
    }
}
