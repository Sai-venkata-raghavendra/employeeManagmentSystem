package com.infosys.project.infosysdemo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;

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

	@ExceptionHandler(Exception.class)
	public ProblemDetail handleSecurity(Exception e) {

		ProblemDetail error = null;
		if (e instanceof BadCredentialsException) {
			error = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), e.getMessage());
			error.setProperty("AccessDenined", "Doesn't Have Access");
		}

		if (e instanceof SignatureException) {
			error = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), e.getMessage());
			error.setProperty("AccessDenined", "Jwt Signature Not Valid");
		}
		if (e instanceof ExpiredJwtException) {
			error = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), e.getMessage());
			error.setProperty("AccessDenined", "Jwt Token Expired");
		}
		return error;
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
