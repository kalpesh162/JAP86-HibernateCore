package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);

	void deleteEmployee(Employee employee);

	void deleteEmployeeById(int id);

	void updateEmployee(Employee employee);

	Employee findById(int id);
	
	List<Employee> findAllEmployee();

}
