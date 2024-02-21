package com.hexaware.springrestjpa.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.exception.EmployeeNotFoundException;
import com.hexaware.springrestjpa.service.EmployeeServiceImpl;
import com.hexaware.springrestjpa.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
 
	   @Autowired
	   IEmployeeService service;
	    
	    @PostMapping("/add")
	    public Employee insertEmployee(@RequestBody  Employee emp) {
	    	//boolean  isValid =	EmployeeServiceImpl.validateEmployeeData(emp);
			
			//Employee employee = null;
			
			//	if(isValid) {
	    	logger.warn( " employee cannot be null");
				return	emp = service.addEmployee(emp);
			//	}

			//return employee;
	    }
		
	    @PutMapping("/update")
		public Employee updateEmployee(@RequestBody @Valid Employee emp) {
	    	return service.updateEmployee(emp);
	    }
		
	    @GetMapping("/get/{eid}")
		public Employee getEmployee(@PathVariable long eid) throws EmployeeNotFoundException {
	    	
	    	
	    	Employee emp =service.getEmployee(eid);
	    	if(emp==null) {
	    		throw new EmployeeNotFoundException();
	    	}
	    	return emp;
	    }
		
	    @DeleteMapping("/delete/{eid}")
		public String deleteEmployee(@PathVariable long eid) {
	    	return service.deleteEmployee(eid);
	    }
	    
		@GetMapping("/getall")
		public List<Employee> getAllEmployee(){
			return service.getAllEmployee();
			}
		
		@GetMapping("/getbyename/{ename}")
		public List<Employee> getByEname(@PathVariable String ename){
			return service.getByEname(ename);
			}
		
		@GetMapping("/getbysalary/{salary}")
		public List<Employee> getBySalary(@PathVariable double salary){
			return service.getBySalary(salary);
			}
		
		@GetMapping("/getbysalarygt/{salary}")
		public List<Employee> getBySalaryGT(@PathVariable double salary){
			return service.getBySalaryGT(salary);
			}
		
		@GetMapping("/getbysalarysorted")
		public List<Employee> getBySalarySorted(){
			return service.getBySalarySorted();
			}
		
		@GetMapping("/getbysalaryrange/{salary1}/{salary2}")
		public List<Employee> getBySalaryRange(@PathVariable double salary1 , @PathVariable double salary2){
			return service.findEmployeesBySalaryRange(salary1, salary2);
			}
		
		@DeleteMapping("/deletebyename/{ename}")
		public String deleteByEname(@PathVariable String ename){
			int count =  service.deleteByName(ename);
			return count+ "records deleted ";
			}
		
		@GetMapping("/getbysalarylt/{salary}")
		public List<Employee> getBySalaryLT(@PathVariable double salary){
			return service.getBySalaryLT(salary);
		}
		
}
