package com.dao;

import java.util.List;

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
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;

		} finally {
			session.close();
		}

	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
