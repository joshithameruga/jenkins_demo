package com.hexaware.springrestjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.springrestjpa.entities.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	   
         List<Employee> findByEname(String ename);
         
         List<Employee> findBySalary(double salary);
         
         //findby is mandatory for these followed by property name
         List<Employee> findBySalaryGreaterThan(double salary);
         
         List<Employee> findBySalaryLesserThan(double salary);
         //try with two parameters
         
         //List<Employee> getBySalarySorted(double salary); no need because we have a predefined method
         
         // Custom Queries   (The method name for customer queries are not mandatory we can take getall ,etc also)
         
         
         //we can use anything hql native , named , jpql etc but we can use a new one known as query
         @Query("select e from Employee e where e.salary between ?1 and ?2")
         //can use named parameters also
         // @Query("select e from Employee e where e.salary between :salary1 and :salary2") 
         List<Employee> findEmployeesBySalaryRange(double salary1 , double salary2);
         
         @Modifying //indicates that this is not normal select stmnt but dml stmnt
         @Query("delete from Employee e where e.ename=?1")
         int deleteByName(String ename);   //int bcoz we know that query returns no of records affected

}
