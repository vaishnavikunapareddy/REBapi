package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.model.Customer;
import com.cg.rebapi.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerWeb {
	@Autowired
	public CustomerServiceImpl customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.listOfCustomer();
	}
	
	@PostMapping("/addcustomers")
	public Customer addEmployee(@RequestBody  Customer customer) {
		 Customer c= customerService.addCustomer(customer);
		return c;
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public Customer deleteCustomer(@PathVariable("id") int cno) {
		if(customerService.checkCustomer(cno)) {
			return customerService.deleteCustomer(cno);
		}
		return null;
	}
	
	
	

}
