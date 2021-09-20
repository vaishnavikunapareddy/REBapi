package com.cg.rebapi.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionsHandler {
//	@ExceptionHandler(EmployeeException.class)
//	public @ResponseBody ErrorInfo employeeExceptionError(EmployeeException e, HttpServletRequest req) {
//		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
//		
//	}
	@ExceptionHandler(BrokerException.class)
	public ResponseEntity<?> errorMsg(String msg){
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
	
	
	

}
