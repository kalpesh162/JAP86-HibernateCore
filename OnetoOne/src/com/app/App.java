package com.app;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Address;
import com.entity.Student;

public class App {

	public static void main(String[] args) {

		StudentDao dao = new StudentDaoImpl();

		System.out.println("====== SAVE STUDENT============");

		Student s1 = new Student("Kalpesh");

		Address address = new Address("MH", "PUNE");

		s1.setAddress(address); // Dont Forget This

		dao.saveStudent(s1);

		System.out.println("-----------------------------------");

	}

}
