package com.hexaware.springrestjpa.service;

import java.util.List;

import com.hexaware.springrestjpa.entities.Employee;


public interface IEmployeeService {
	
    public Employee addEmployee(Employee emp);
	
	public Employee updateEmployee(Employee emp);
	
	public Employee getEmployee(long eid);
	
	public String deleteEmployee(long eid);
	
	public List<Employee> getAllEmployee();
	
	public List<Employee> getByEname(String ename);
	
	public List<Employee> getBySalary(double salary);
	
	public List<Employee> getBySalaryGT(double salary);
	
	public List<Employee> getBySalaryLT(double salary);
	
	public List<Employee> getBySalarySorted();
	
	public  List<Employee> findEmployeesBySalaryRange(double salary1 , double salary2);
	
	public int deleteByName(String ename);
}
