package com.infosys.project.infosysdemo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandl {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> handleEmployeeErrors(EmployeeNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error Code", "400");
		errorMap.put("statusCode", HttpStatus.BAD_REQUEST.toString());
		errorMap.put("errorMessage", ex.getMessage());
		
		return errorMap;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleUserErrors(UserNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error Code", "400");
		errorMap.put("statusCode", HttpStatus.BAD_REQUEST.toString());
		errorMap.put("errorMessage", ex.getMessage());
		
		return errorMap;
	}
}
