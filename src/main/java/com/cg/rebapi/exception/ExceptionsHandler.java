package com.cg.rebapi.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler  extends ResponseEntityExceptionHandler {
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException elementException)
	{
		return new ResponseEntity<String>("No value is present in db",HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<?> handleEmptyException(EmptyListException elementException)
	{
		return new ResponseEntity<String>("List is empty ,no record to show",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<?> handleEmptyFieldException(EmptyFieldException elementException)
	{
		return new ResponseEntity<String>("Filed can to be empty",HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Please change http method type",HttpStatus.BAD_REQUEST);
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String ,String> errors=new HashMap<>();
		
	ex.getBindingResult().getAllErrors().forEach((error)->{
		
			String fieldName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object> (errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentsNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentsNotValidException mexp) {
        return new ResponseEntity<String>("Invalid input", HttpStatus.BAD_REQUEST);
    } 
	@ExceptionHandler(BrokerException.class)
	public @ResponseBody ErrorInfo brokerExceptionError(BrokerException e) {
		return new ErrorInfo(e.getMessage());
	}
	@ExceptionHandler(CustomerException.class)
	public @ResponseBody ErrorInfo customerExceptionError(CustomerException e) {
		return new ErrorInfo(e.getMessage());
	}

	@ExceptionHandler(AddressException.class)
	public @ResponseBody ErrorInfo addressExceptionError(AddressException e) {
		return new ErrorInfo(e.getMessage());
	}

	@ExceptionHandler(FlatException.class)
	public @ResponseBody ErrorInfo flatExceptionError(FlatException e) {
		return new ErrorInfo(e.getMessage());
	}

	@ExceptionHandler(PlotException.class)
	public @ResponseBody ErrorInfo plotExceptionError(PlotException e) {
		return new ErrorInfo(e.getMessage());
	}

	@ExceptionHandler(ShopException.class)
	public @ResponseBody ErrorInfo shopExceptionError(ShopException e) {
		return new ErrorInfo(e.getMessage());
	}

	@ExceptionHandler(OwnerException.class)
	public @ResponseBody ErrorInfo ownerExceptionError(OwnerException e) {
		return new ErrorInfo(e.getMessage());
	}

	@ExceptionHandler(PropertyException.class)
	public @ResponseBody ErrorInfo propertyExceptionError(PropertyException e) {
		return new ErrorInfo(e.getMessage());
	}
	
	@ExceptionHandler(PropertyTypeException.class)
	public @ResponseBody ErrorInfo propertyTypeExceptionError(PropertyTypeException e) {
		return new ErrorInfo(e.getMessage());
	}
	
	
	


}