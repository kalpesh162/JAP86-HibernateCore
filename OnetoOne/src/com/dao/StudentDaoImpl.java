package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;
import com.utility.HibernateUtility;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void saveStudent(Student student) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(student);
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
