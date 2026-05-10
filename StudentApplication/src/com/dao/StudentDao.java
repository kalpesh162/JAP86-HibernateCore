package com.dao;

import java.util.List;

import com.entity.Student;

public interface StudentDao {

	void saveStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(Student student);

	void deleteStudentById(int id);

	Student getStudentById(int id);

	List<Student> getAllStudent();

}
