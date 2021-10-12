package com.cg.rebapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.exception.UserNotFoundException;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.model.User;
import com.cg.rebapi.repository.UserRepository;
import com.cg.rebapi.serviceimpl.BrokerServiceImpl;
import com.cg.rebapi.serviceimpl.UserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserWeb {	
	@Autowired
	UserServiceImpl userServiceimpl;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BrokerServiceImpl brokerServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user,BindingResult bindingResult) throws MethodArgumentsNotValidException {
		userServiceimpl.registerUser(user);
		return new ResponseEntity<String>("Registration Successful", HttpStatus.ACCEPTED);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) throws UserNotFoundException {
		boolean userExist = userServiceimpl.isUserExist(id);
		if(userExist) {
			userServiceimpl.deleteUser(id);
			return new ResponseEntity<String>("User with "+id+" deleted successfully", HttpStatus.OK);
		}
		//throw new UserNotFoundException(userName);
		return new ResponseEntity<String>("User with "+id+" not found ", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id){
		boolean userExist = userServiceimpl.isUserExist(id);
		if(userExist) {
			User user=userServiceimpl.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		//throw new UserNotFoundException(userName);
		return new ResponseEntity<String>("User with "+id+" not found ", HttpStatus.NOT_FOUND);
		
	}
	
//	@GetMapping("/login")
//	public ResponseEntity<?> userValidate(@RequestBody User user){		
//		if(userServiceimpl.validateUser(user)){
//				return new ResponseEntity<String>("Login Successfull", HttpStatus.ACCEPTED);
//			}
//		return new ResponseEntity<String>("Login Failed", HttpStatus.NOT_ACCEPTABLE);
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userValidate(@RequestBody User user){	
		if(userServiceimpl.validateUser(user)){
			return new ResponseEntity<String>("Login Successfull", HttpStatus.ACCEPTED);
		}
	return new ResponseEntity<String>("Login Failed", HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> getUsersList(){
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	
	}
	
}