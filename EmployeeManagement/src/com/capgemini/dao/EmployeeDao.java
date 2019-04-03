package com.capgemini.dao;
import java.util.List;

import com.capgemini.bean.Employee;
public interface EmployeeDao {
	public String addEmployee(Employee e);
	public String deleteEmployee(String empid);
	public Employee searchEmployee(String empid);
	public List<Employee> allEmployee();
}
