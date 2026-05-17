package com.app;

import com.dao.DepartmentDaoImpl;
import com.dao.DepatmentDao;
import com.entity.Department;
import com.entity.Student;

public class App {

	public static void main(String[] args) {
		Student s1 = new Student("Kareena");
		Student s2 = new Student("Raveena");
		Student s3 = new Student("Sakeena");
		Student s4 = new Student("Aliya");
		Student s5 = new Student("Shruti");

		Department department1 = new Department("CS");
		Department department2 = new Department("ELECTRONICS");

		department1.getStudents().add(s1);
		department1.getStudents().add(s2);
		department1.getStudents().add(s3);

		department2.getStudents().add(s4);
		department2.getStudents().add(s5);

		DepatmentDao dao = new DepartmentDaoImpl();
		dao.saveDepartment(department1);

		System.out.println("SAVE CS DEPT");
		dao.saveDepartment(department2);
		System.out.println("SAVE ELECTRONICS DEPT");
	}

}
