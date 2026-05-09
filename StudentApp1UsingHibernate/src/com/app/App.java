package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class App {

	public static void main(String[] args) {

		System.out.println("Application Started");
		// Step 1
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("Configurated Read  1");
		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("Session Factory 2");
		Student student = new Student();
		student.setId(1);
		student.setName("Kalpesh");
		student.setMarks(66.66);

		Session session = factory.openSession();
		System.out.println("Session Created - 3");

		// ADD UPDATE DELETE --> Transaction
		// SELECT no need of Transaction

		Transaction tx = session.beginTransaction();
		System.out.println("Transcation Created 4");

		// Ready To ADD UPDATE DELETE --> Transaction

		System.out.println("-----------------------");
		session.save(student); // internally
		System.out.println("-----------------------");
		
		System.out.println("** BEFORE COMMINT");
		tx.commit(); // Gurantee Data will be added in table
		
		System.out.println("Done ");
		session.close();
		factory.close();

		System.out.println("END APPLICATION");

	}

}
