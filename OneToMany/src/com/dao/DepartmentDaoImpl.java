package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Department;
import com.utility.HibernateUtility;

public class DepartmentDaoImpl implements DepatmentDao {

	@Override
	public void saveDepartment(Department department) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			System.out.println("--------------SAVE ----------------");
			tx = session.beginTransaction();
			session.persist(department);
			System.out.println("--------------persist Call Done ----------------");
			tx.commit();
			System.out.println("--------------After TX COmmit ----------------");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				throw e;
			}
		} finally {
			session.close();
		}

	}

}
