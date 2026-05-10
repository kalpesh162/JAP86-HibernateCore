package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class ReadData {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		System.out.println("Session Created");
		// Student student = (Student) session.get(Student.class, 1);
		Student student = (Student) session.load(Student.class, 1);
		System.out.println("Session Used");

		System.out.println("--------");
		System.out.println(student);
		System.out.println("--------");

		session.close();

		sessionFactory.close();

	}

}
