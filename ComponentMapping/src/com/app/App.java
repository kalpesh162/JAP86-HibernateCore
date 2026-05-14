package com.app;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.entity.Address;
import com.entity.Employee;

public class App {

	public static void main(String[] args) {

		Employee employee = new Employee();
		Address address = new Address("FC ROAD", "PUNE", "MH", "411025");
		employee.setName("Kalpesh");
		employee.setSalary(10000);

		employee.setAddress(address);

		EmployeeDao dao = new EmployeeDaoImpl();
		dao.saveEmployee(employee);

	}

}
