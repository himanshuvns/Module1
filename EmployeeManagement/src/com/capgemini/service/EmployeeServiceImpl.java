package com.capgemini.service;
import java.util.List;
import com.capgemini.bean.Employee;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.EmployeeDaoImpl;;

public class EmployeeServiceImpl implements EmployeeService{
	

	EmployeeDao edao = new EmployeeDaoImpl();
	
	@Override
	public String addEmployee(Employee e) {
		if(e==null || e.getName().length()<4 || e.getAge()<18)
		{
			return "Invalid Data";
		}
		else
			return edao.addEmployee(e);
	}

	@Override
	public String deleteEmployee(String empid) {
		if(empid==null || empid.length()<4)
		{
			return "Invalid Employee ID";
		}
		else
		{
			return edao.deleteEmployee(empid);
		}
	}

	@Override
	public Employee searchEmployee(String empid) {
		if(empid == null || empid.length()<4)
		{
			return null;
		}
		else
		{
			return edao.searchEmployee(empid);
		}
	}
	
	@Override
	public List<Employee> allEmployee() {
		// TODO Auto-generated method stub
		return edao.allEmployee();
	}

}
