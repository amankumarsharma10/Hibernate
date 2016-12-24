package com.hibernate;

import com.hibernate.dao.CRUDOperation;
import com.hibernate.dao.CRUDOperationImp;
import com.hibernate.persistance.Department;
import com.hibernate.persistance.Employee;
import com.hibernate.util.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import java.util.List;

public class DemoAppApplication {

	private CRUDOperation crudOperation;

	DemoAppApplication(){
		crudOperation = new CRUDOperationImp();
	}
	public static void main(String[] args) {

		DemoAppApplication demoAppApplication = new DemoAppApplication();

		//save
		demoAppApplication.save();

	//	demoAppApplication.getEmployee();

	//	demoAppApplication.getAllEmployees();
	}

	public void save(){
		Transaction tx;
		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee emp = new Employee();
		emp.setFirstName("Kamal");
		emp.setLastName("Kumar");
		Department d1 = new Department(1,"LND");
		Department d2 = new Department(2,"Accounting");


		tx = session.beginTransaction();
		try {
			session.save(d1);
			session.save(d2);

			Department dept= session.get(Department.class,2);
			emp.setDepartment(dept);
			crudOperation.save(emp,session);
		}catch (HibernateException he)
		{
			he.printStackTrace();
		}finally {
			try{
			//	tx.commit();
				session.flush();
				session.close();
			}catch (TransactionException e){e.printStackTrace(); tx.rollback();}
		}
	}

	private void getEmployee() {

		Session session = HibernateUtility.getSessionFactory().openSession();
		Employee employee = crudOperation.getEmployee(1,session);

		session.close();
	}

	private void getDepartment(){
		Session session = HibernateUtility.getSessionFactory().openSession();
		Department department = crudOperation.getDepartment(1,session);
		System.out.println(department.getDeptId());

		session.close();
	}

	private void getAllEmployees(){

		List<Employee> employeeList = crudOperation.getAllEmployees(HibernateUtility.getSessionFactory().openSession());

		for (Employee employee:employeeList) {
			System.out.println();
//			System.out.println("EMpId=> "+employee.getEmpId()+", Name=> "+employee.getFirstName() +", DepName=> "+employee.getDepartment().getDeptName()+", Role1=> "+employee.getRolesList().get(0).getRoleName()+", Role2=> "+employee.getRolesList().get(1).getRoleName());
		}
	}
}
