package com.app;

import java.util.List;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;

public class App {

	public static void main(String[] args) {
		Student s1 = new Student(11, "Rahul", 99);
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.saveStudent(s1);

		System.out.println("Save Student");
		System.out.println("+++++++++++++++++++++++++++++");

		System.out.println("Read Student");
		Student student = studentDao.getStudentById(11);
		System.out.println(student);

		System.out.println("+++++++++++++++++++++++++++++");

		s1.setName("Kahul");
		s1.setMarks(55.55);
		System.out.println("Update ");
		studentDao.updateStudent(student);
		studentDao.updateStudent(s1);
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("Read Student");
		Student student1 = studentDao.getStudentById(11);
		System.out.println(student1);

		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("DELETE");
		studentDao.deleteStudent(s1);
		System.out.println("----------------------");

		System.out.println("Read ALL Students");

		List<Student> list = studentDao.getAllStudent();

		for (Student stud : list)
			System.out.println(stud);

	}

}
