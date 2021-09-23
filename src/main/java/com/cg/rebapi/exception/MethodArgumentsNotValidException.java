package com.cg.rebapi.exception;

public class MethodArgumentsNotValidException extends Exception{
	String errorMsg;
	
	public MethodArgumentsNotValidException() {
		super("invalid arguments");
	}

	

}
