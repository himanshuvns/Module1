package com.capgemini.main;
import com.capgemini.bean.Employee;
import com.capgemini.service.EmployeeServiceImpl;
import com.capgemini.service.EmployeeService;
public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeService empser = new EmployeeServiceImpl();
		Employee emp = new Employee("115", "Himanshu", 25, 20125);
		Employee emp1 = new Employee("116", "Satyam", 28, 12525);
		Employee emp2 = new Employee("117", "Dola Sai Ram", 26, 25485);
		empser.addEmployee(emp);
		empser.addEmployee(emp1);
		empser.addEmployee(emp2);
		System.out.println(empser.allEmployee());
		empser.deleteEmployee("116");
		System.out.println(empser.allEmployee());
	}

}











