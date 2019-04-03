package com.capgemini.dao;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.bean.Employee;

import com.capgemini.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	List<Employee> li = new ArrayList<Employee>();

	@Override
	public String addEmployee(Employee e) {
		li.add(e);
		return "Employee Added";
	}

	@Override
	public String deleteEmployee(String empid) {
		for(Employee e:li)
		{
			if(e.getEmpid().equals(empid))
			{
				li.remove(e);
			}
		}
		return "Employee Deleted";
	}

	@Override
	public Employee searchEmployee(String empid) {
		Employee emp1=null;
		for(Employee e:li)
		{
			if(e.getEmpid().equals(empid))
			{
				return emp1=e;
			}
		}
		return emp1;
	}

	@Override
	public List<Employee> allEmployee() {
		// TODO Auto-generated method stub
		return li;
	}
	

}
