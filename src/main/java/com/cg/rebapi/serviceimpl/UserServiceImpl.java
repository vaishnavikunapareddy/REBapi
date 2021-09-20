package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.User;
import com.cg.rebapi.repository.UserRepository;
import com.cg.rebapi.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Override
	public boolean validate(User user) {
		   if(userRepository.existsById(user.getUserName())){
			  User u = userRepository.findById(user.getUserName()).get();
			   if(user.getPassword().equals(u.getPassword())) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
		@Override
	   public List<User> getAllUsers() {
		  return userRepository.findAll();
	   }

}
