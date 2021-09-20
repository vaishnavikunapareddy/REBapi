package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public boolean validate(User user);

}
