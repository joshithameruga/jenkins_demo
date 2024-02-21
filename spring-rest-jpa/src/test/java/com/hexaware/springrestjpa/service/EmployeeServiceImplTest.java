package com.hexaware.springrestjpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.springrestjpa.entities.Employee;

@SpringBootTest
//@Transactional  (if i write transactional here the changes will be rolled back)
class EmployeeServiceImplTest {
	
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImplTest.class);
	
	@Autowired
	IEmployeeService service;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	@DisplayName("insertemployee")
	void testAddEmployee() {
		Employee emp = new Employee(121,"Jerry",4000);
		Employee e1 = service.addEmployee(emp);
		assertNotNull(emp);
		assertEquals(121,e1.getEid());
		assertTrue(e1.getEid()>0);
		logger.info("employee added successfully");
		
	}

	@Test
	void testUpdateEmployee() {
		Employee emp = new Employee(121,"Tom",5000);
		Employee e1 = service.updateEmployee(emp);
		assertNotNull(emp);
		assertEquals("Tom",e1.getEname());
		assertTrue(e1.getEid()>0);
		assertFalse(e1.getEid()<0);
	}

	@Test
	void testGetEmployee() {
		Employee emp = service.getEmployee(101);
		assertEquals("monica",emp.getEname());
		
	}

	@Test
	void testGetAllEmployee() {
		List list = service.getAllEmployee();
		boolean flag=list.isEmpty();
		assertFalse(flag);
	}

}
