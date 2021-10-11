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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
import com.cg.rebapi.serviceimpl.CustomerServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("api/customers")
public class CustomerWeb {
	@Autowired
	public CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> addOrUpdateCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws MethodArgumentsNotValidException {
//		if(bindingResult.hasErrors()) {
//			throw new MethodArgumentsNotValidException();
//		}
//
//		else if(customer.getCustomerAddress()==null)
//			return new ResponseEntity<String>("Customer should have address, please provide address" , HttpStatus.NOT_ACCEPTABLE);
//		else if(addressServiceImpl.checkAddress(customer.getCustomerAddress().getId())) {
		Address address=addressServiceImpl.addAddress(customer.getCustomerAddress());
				Customer customerSaved=customerServiceImpl.addCustomer(customer);
				return new ResponseEntity<Customer>(customerSaved, HttpStatus.CREATED);
//		}
	//	return new ResponseEntity<String>("customer cannot be added, Address id"+customer.getCustomerAddress().getId()+ " not found" , HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") long id) throws CustomerException{
		Customer customer=customerServiceImpl.getCustomer(id);
		if(customer==null)
			return new ResponseEntity<>(customer,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(customer,HttpStatus.OK);
		
		
	}
	@GetMapping("")
	public ResponseEntity<?> getCustomers(){
		List<Customer> customerList= customerServiceImpl.listOfCustomers();
		if(customerList==null)
			return new ResponseEntity<>(customerList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customerList,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id) throws CustomerException{
		Customer customerSaved=customerServiceImpl.deleteCustomer(id);
		if(customerSaved==null)
			return new ResponseEntity<>(customerSaved,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customerSaved,HttpStatus.OK);
	}
	
	@GetMapping("/flatlist/{id}")
	public ResponseEntity<?> listOfFlat(@PathVariable("id") long id) throws CustomerException{
		List<Flat> flatList= customerServiceImpl.listOfFlat(id);
		if(flatList==null)
			return new ResponseEntity<>(flatList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(flatList,HttpStatus.OK);
	}
	
	@GetMapping("/shoplist/{id}")
	public ResponseEntity<?> listOfShop(@PathVariable("id") long id) throws CustomerException{
		List<Shop> shopList= customerServiceImpl.listOfShop(id);
		if(shopList==null)
			return new ResponseEntity<>(shopList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(shopList,HttpStatus.OK);
	}
	
	@GetMapping("/plotlist/{id}")
	public ResponseEntity<?> listOfPlot(@PathVariable("id") long id) throws CustomerException{
		List<Plot> plotList= customerServiceImpl.listOfPlot(id);
		if(plotList==null)
			return new ResponseEntity<>(plotList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(plotList,HttpStatus.OK);
	}
	
	

}