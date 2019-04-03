package com.igate.service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.igate.labs.Department;
import com.igate.labs.EmployeeRepository;
import com.igate.streamlab.Employee;

public class EmployeeService {
	

	
	public double totalSalary()
	{
		Stream<Employee> s= EmployeeRepository.getEmployees().stream();
	List<Double> l1 = s.map((e)->e.getSalary()).collect(Collectors.toList());
	Stream<Double> d1 = l1.stream();
	Optional<Double> o1 = d1.reduce((a,b)->a+b);
	return o1.get();
	}
	
	public void nameDepartment()
	{
		Stream<Department> d= EmployeeRepository.getDepartments().stream();
		List<String> l1 = d.map((e)->e.getDepartmentName()).collect(Collectors.toList());
		Stream<String> d1 = l1.stream();
		d1.forEach(e->System.out.println(e));	
	}
	public void countEmployee()
	{
		List<Employee> li = EmployeeRepository.getEmployees();
		Map<Department, Long> m = li.stream().filter(e->e.getDepartment()!=null).collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		m.forEach((k,v)->System.out.println(k.getDepartmentName()+" "+v));
		
	}
	public void seniorEmployee()
	{
		Stream<Employee> s = EmployeeRepository.getEmployees().stream();
		Optional<Employee> o = s.min((a,b)->a.getHireDate().compareTo(b.getHireDate()));
		System.out.println(o.get());
	}
	
	public void durationEmployee()
	{
		Stream<Employee> s = EmployeeRepository.getEmployees().stream();
		s.forEach((e)->{System.out.println(e.getFirstName()+" time period="+Period.between(e.getHireDate(), LocalDate.now()));});
		
	}
	public void withoutDep()
	{
		Stream<Employee> s = EmployeeRepository.getEmployees().stream();
		s.filter((e)->e.getDepartment()==null).forEach(e->System.out.println(e.getFirstName()+" "+e.getLastName()));	
	}
	public void highestCount()
	{
		List<Employee> li = EmployeeRepository.getEmployees();
		Map<Department, Long> m = li.stream().filter(e->e.getDepartment()!=null).collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		
		
	}
	public void dayOfWeek()
	{
		List<Employee> li = EmployeeRepository.getEmployees();
		li.forEach((e)->System.out.println("name of Employee="+e.getFirstName()+" "+e.getLastName()+"\tDate of Joining="+e.getHireDate()+"\tday of week started="+e.getHireDate().getDayOfWeek()+"\n"));
	}
	public void reportManager()
	{
		List<Employee> li = EmployeeRepository.getEmployees();
		li.forEach((e)->System.out.println(e.getFirstName()+" "+e.getLastName()+" reports to manager having id "+e.getManagerId()));
	}
	
	public static void main(String as[])
	{
		EmployeeService emp = new EmployeeService();
		//System.out.println(EmployeeRepository.getEmployees());
		//System.out.println(emp.totalSalary());
		//emp.nameDepartment();
		//emp.seniorEmployee();
		//emp.durationEmployee();
		//emp.withoutDep();
		//emp.dayOfWeek();
		emp.reportManager();
	}
	
	
}
