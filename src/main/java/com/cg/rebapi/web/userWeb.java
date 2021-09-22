package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.model.User;
import com.cg.rebapi.serviceimpl.UserServiceImpl;


@RestController
@RequestMapping("/users")
public class userWeb {
	@Autowired
	public UserServiceImpl userService;
	
	@GetMapping("/validate")
	public String validate(@RequestBody User user) {
		
		if(userService.validate(user)){
				return "Login Successful";
			}
		return "Login Failed";
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	

}
