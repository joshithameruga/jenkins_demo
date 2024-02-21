package com.hexaware.springrestjpa.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.repository.EmployeeRepository;

import jakarta.transaction.Transactional;


@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService {
     
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Employee addEmployee(Employee emp) {
		logger.info( emp + "employee is added from add service");
		return repo.save(emp);
		
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Employee getEmployee(long eid) {
		Employee emp=null;
		Optional<Employee> optional =repo.findById(eid);
		if(optional.isPresent()) {
			 emp= optional.get();
		}
		return emp;
		
		//return repo.findById.orelse
	}

	@Override
	public String deleteEmployee(long eid) {
		 repo.deleteById(eid);
		 return "record deleted";
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public List<Employee> getByEname(String ename) {
		return repo.findByEname(ename);
	}

	@Override
	public List<Employee> getBySalary(double salary) {
		
		return repo.findBySalary(salary);
	}

	@Override
	public List<Employee> getBySalaryGT(double salary) {
		
		return repo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> getBySalarySorted() {
	
	  //return repo.findAll(Sort.by(Order.asc("salary")));
	   return repo.findAll(Sort.by("salary"));
		
		
	}

	@Override
	public List<Employee> findEmployeesBySalaryRange(double salary1, double salary2) {
		
		return repo.findEmployeesBySalaryRange(salary1, salary2);
	}

	@Override
	public int deleteByName(String ename) {
		
		return repo.deleteByName(ename);
	}

	@Override
	public List<Employee> getBySalaryLT(double salary) {
		return repo.findBySalaryLesserThan(salary);
		
	}
	
	
 /*public static boolean  validateEmployeeData(Employee emp) {
		
		String ename = emp.getEname();
		
			boolean flag = false;
		
			if(emp.getEid() > 99  && emp.getSalary() > 1000 && ename.equals(ename.toUpperCase())) {
				
				flag = true;
					
			}
		
			return flag;

}*/
	
}
