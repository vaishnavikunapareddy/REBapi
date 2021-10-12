package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.User;

public interface UserService {

	void deleteUser(Long id);

	boolean isUserExist(Long id);

	User registerUser(User user);

	boolean validateUser(User user);
	

}
