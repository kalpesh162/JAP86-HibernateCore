package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.utility.HibernateUtility;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public void saveEmployee(Employee employee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.persist(employee);
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
