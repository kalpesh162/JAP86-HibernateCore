package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.entity.Address;
import com.entity.Employee;
import com.utility.HibernateUtility;

public class App {

	public static void main(String[] args) {
		/*
		 * Employee employee = new Employee(); Address address = new Address("FC ROAD",
		 * "PUNE", "MH", "411025"); employee.setName("Kalpesh");
		 * employee.setSalary(10000);
		 * 
		 * employee.setAddress(address);
		 * 
		 * EmployeeDao dao = new EmployeeDaoImpl(); dao.saveEmployee(employee);
		 */

		System.out.println("+++++++++++++++++++++++++++");

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session1 = factory.openSession();
		Transaction tx1 = session1.beginTransaction();
		Employee employee1 = (Employee) session1.get(Employee.class, 1);
		employee1.setName("Karsihma");
		employee1.setSalary(23000);

		session1.evict(employee1); // employee1 is in Detached State

		Session session2 = factory.openSession();
		Transaction tx2 = session2.beginTransaction();
		Employee employee2 = (Employee) session2.get(Employee.class, 1);

		// Deatched --> session.update(obj) org.hibernate.NonUniqueObjectException
		 session2.update(employee1); //
		//session1.update(employee1); // org.hibernate.NonUniqueObjectException

		System.out.println("((((((((((((((((((((((");
		// session1.merge(employee1);
		System.out.println("((((((((((((((((((((((");
		// Detached State ----> PerSist State
		// session2.merge(employee1);

		System.out.println("------------------------------");
		tx2.commit();
		System.out.println("------------------------------");

		System.out.println("*******");

	}

}
