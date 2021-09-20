package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerWeb {
	@Autowired
	public CustomerServiceImpl customerService;
	
	@GetMapping("/getcustomers")
	public ResponseEntity<?> getCustomers(){
		List<Customer>customerList= customerService.listOfCustomers();
		return new ResponseEntity<>(customerList,HttpStatus.OK);
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer customerSaved=customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customerSaved, HttpStatus.CREATED);
	}
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") long id){
		List<Customer> customerList= customerService.listOfCustomers();
		return new ResponseEntity<>(customerList,HttpStatus.OK);
		
	}
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") long bno) throws CustomerException{
		Customer customerSaved=customerService.deleteCustomer(bno);
		return new ResponseEntity<>(customerSaved,HttpStatus.OK);
	}
	
	
	

}