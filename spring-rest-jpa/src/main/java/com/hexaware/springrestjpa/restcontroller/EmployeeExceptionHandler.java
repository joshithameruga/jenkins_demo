package com.hexaware.springrestjpa.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hexaware.springrestjpa.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND , reason="employee doesnt exist in db")
    @ExceptionHandler({EmployeeNotFoundException.class})      
	public void handleExp() {
    	  
      }
}
