package com.cg.rebapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
import com.cg.rebapi.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("api/customers")
public class CustomerWeb {
	@Autowired
	public CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> addOrUpdateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws MethodArgumentNotValidException {
		//if(bindingResult.hasErrors())
		//	throw new MethodArgumentNotValidException())
		if(addressServiceImpl.checkAddress(customer.getCustomerAddress().getId())) {
				Customer customerSaved=customerServiceImpl.addCustomer(customer);
				return new ResponseEntity<Customer>(customerSaved, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("customer cannot be added, Address id"+customer.getCustomerAddress().getId()+ " not found" , HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBroker(@PathVariable("id") long id) throws CustomerException{
		Customer customer=customerServiceImpl.getCustomer(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
		
	}
	@GetMapping("")
	public ResponseEntity<?> getCustomer(){
		List<Customer> customerList= customerServiceImpl.listOfCustomers();
		return new ResponseEntity<>(customerList,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") long bno) throws CustomerException{
		Customer customerSaved=customerServiceImpl.deleteCustomer(bno);
		return new ResponseEntity<>(customerSaved,HttpStatus.OK);
	}
	
	
	

}