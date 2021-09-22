package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.model.Broker;
import com.cg.rebapi.model.User;
import com.cg.rebapi.serviceimpl.UserServiceImpl;


@RestController
@RequestMapping("api/users")
public class userWeb {
	@Autowired
	public UserServiceImpl userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> validate(@RequestBody User user) {
		
		if(userService.validate(user)){
				return new ResponseEntity<String>("Logged in successfully", HttpStatus.OK);
			}
		return new ResponseEntity<String>("Login Failed!!", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	

}
