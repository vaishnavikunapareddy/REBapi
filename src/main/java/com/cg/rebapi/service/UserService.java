package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.User;

public interface UserService {

	public boolean validateUser(User user);

	public void deleteUser(String userName);

	public boolean isUserExist(String userName);

	public User registerUser(User user);

//	public List<User> getAllUsers();
//
//	public boolean validate(User user);
//	
////	public User signIn(User user);
////	
////	public User signOut();

}
