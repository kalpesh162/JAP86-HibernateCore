package com.app;

import java.util.List;
import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;

public class App {

	private static Student getStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENter Name ");
		String name = scanner.nextLine();
		System.out.println("ENter Marks ");
		double marks = scanner.nextDouble();
		Student student = new Student();
		student.setName(name);
		student.setMarks(marks);
		return student;
	}

	public static void main(String[] args) {

		// Use DAO
		StudentDao studentDao = new StudentDaoImpl();

		int option, x;

		do {

			Scanner scanner = new Scanner(System.in);
			System.out.println("******************");
			System.out.println("***1 : ADD STUDENT     *********");
			System.out.println("***2 : DELETE STUDENT     ***************");
			System.out.println("***3 : GET STUDENT  ***************");
			System.out.println("***4 : UPDATE STUDENT  ***************");
			System.out.println("***5 : READ ALL LIST   ***************");
			System.out.println("Enter Option ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				Student s1 = getStudent();
				studentDao.saveStudent(s1);
				System.out.println("**** ADD SUCCESS ****");
				break;

			case 2:
				System.out.println("Enter Student ID to DELETED");
				int dId = scanner.nextInt();
				studentDao.deleteStudentById(dId);
				System.out.println("DELETE SUCCESS");
				break;

			case 3:
				System.out.println("Enter Student ID to Read");
				int rId = scanner.nextInt();
				Student student = studentDao.getStudentById(rId);
				System.out.println(student); // Use Formatting of to String Here to print

			case 4:
				System.out.println("Enter EXISTING  Student ID ");
				int exId = scanner.nextInt();
				Student student1 = studentDao.getStudentById(exId);
				System.out.println(student1); // Display
				if (student1 != null) {
					System.out.println("Enter Updated Info of Student Below ");
					Student updatedStudent = getStudent();
					// dont forget to Set the id
					updatedStudent.setId(exId);
					studentDao.updateStudent(updatedStudent);
					System.out.println("Student UPATED SUCCESSFULLY");
				} else {
					System.out.println("No Student Exist with ID " + exId);
					// better approach use customized exception

				}

			case 5:
				System.out.println("STUDENT LIST ");
				List<Student> list = studentDao.getAllStudent();

				printList(list);

			default:
				break;
			}

			System.out.println("Press 1 for continue ...");
			System.out.println("Enter ");
			x = scanner.nextInt();

		} while (x == 1);

	}

	private static void printList(List<Student> list) {
		System.out.println("---------------------------------");
		System.out.println("ID            NAME            MARKS");
		System.out.println("---------------------------------");
		for (Student student : list) {
			System.out.printf("%4d", student.getId());
			System.out.printf("%18s", student.getName());
			System.out.printf("%12.2f", student.getMarks());
			System.out.println();
		}

	}

}

/*
 * Student s1 = new Student(); s1.setName("Rahul"); s1.setMarks(79.56);
 * StudentDao studentDao = new StudentDaoImpl(); studentDao.saveStudent(s1);
 * 
 * System.out.println("Save Student");
 * System.out.println("+++++++++++++++++++++++++++++");
 * 
 * System.out.println("Read Student"); Student student =
 * studentDao.getStudentById(2); System.out.println(student);
 * 
 * System.out.println("+++++++++++++++++++++++++++++");
 * 
 * s1.setName("Karan"); s1.setMarks(85.55); System.out.println("Update ");
 * studentDao.updateStudent(student); studentDao.updateStudent(s1);
 * System.out.println("+++++++++++++++++++++++++++++");
 * System.out.println("Read Student"); Student student1 =
 * studentDao.getStudentById(2); System.out.println(student1);
 * 
 * System.out.println("+++++++++++++++++++++++++++++");
 * System.out.println("DELETE"); studentDao.deleteStudent(s1);
 * System.out.println("----------------------");
 * 
 * System.out.println("Read ALL Students");
 * 
 * List<Student> list = studentDao.getAllStudent();
 * 
 * for (Student stud : list) System.out.println(stud);
 * 
 */