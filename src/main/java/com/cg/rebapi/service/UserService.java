package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.User;

public interface UserService {
	/* Login User */
	public boolean validateUser(User user);
	//delete user
	public void deleteUser(String userName);
	/*Validate User*/
	public boolean isUserExist(String userName);
	/* Register User */
	public User registerUser(User user);


}
