package com.dao;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public void deleteEmployee(Employee employee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteEmployeeById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Employee employee = findById(id);
		try {
			if (employee != null) {

				tx = session.beginTransaction();
				session.delete(employee);
				tx.commit();
			}

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Employee findById(int id) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Employee employee = null;
		try {

			employee = (Employee) session.get(Employee.class, id);
			return employee;

		} catch (Exception e) {

			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void updateEmployee(Employee employee) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(employee);
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Employee> findAllEmployee() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		String hql = "from Employee e";
		Query<Employee> query = session.createQuery(hql);
		return query.list();

	}

}
