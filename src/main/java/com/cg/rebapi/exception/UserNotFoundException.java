package com.cg.rebapi.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String userName) {
		super("User name : "+userName+" was not found to delete");
	}

}
