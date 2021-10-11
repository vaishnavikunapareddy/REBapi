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

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
import com.cg.rebapi.serviceimpl.BrokerServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("api/brokers")
public class BrokerWeb {
	@Autowired
	public BrokerServiceImpl brokerServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getBrokers(){
		List<Broker> brokerList= brokerServiceImpl.listOfBrokers();
		if(brokerList==null)
			return new ResponseEntity<>(brokerList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(brokerList,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addOrUpdateBroker(@Valid @RequestBody Broker broker, BindingResult bindingResult) throws MethodArgumentsNotValidException{
//		if(bindingResult.hasErrors()) {
//				throw new MethodArgumentsNotValidException();
//			}
//		else if((broker.getBrokerAddress()==null))
		Address address=addressServiceImpl.addAddress(broker.getBrokerAddress());
		//if((broker.getBrokerAddress()==null))
		//		return new ResponseEntity<String>("Broker should have address, please provide address" , HttpStatus.NOT_ACCEPTABLE);
	//	else if(addressServiceImpl.checkAddress(broker.getBrokerAddress().getId())) {
			//	Address addressServi
				Broker brokerSaved=brokerServiceImpl.addBroker(broker);
				return new ResponseEntity<Broker>(brokerSaved, HttpStatus.CREATED);
		//}
		//return new ResponseEntity<String>("broker cannot be added, Address id"+broker.getBrokerAddress().getId()+ " not found" , HttpStatus.NOT_ACCEPTABLE);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBroker(@PathVariable("id") long id) throws BrokerException{
		Broker broker=brokerServiceImpl.getBroker(id);
		if(broker==null)
			return new ResponseEntity<>(broker,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(broker,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBroker(@PathVariable("id") long bno) throws BrokerException{
		
		Broker brokerSaved=brokerServiceImpl.deleteBroker(bno);
		
		if(brokerSaved==null)
			return new ResponseEntity<>(brokerSaved,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(brokerSaved,HttpStatus.OK);
	}
	
	@GetMapping("/flatlist/{id}")
	public ResponseEntity<?> listOfFlat(@PathVariable("id") long id) throws BrokerException{
		List<Flat> flatList= brokerServiceImpl.listOfFlat(id);
		if(flatList==null)
			return new ResponseEntity<>(flatList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(flatList,HttpStatus.OK);
	}
	
	@GetMapping("/shoplist/{id}")
	public ResponseEntity<?> listOfShop(@PathVariable("id") long id) throws BrokerException{
		List<Shop> shopList= brokerServiceImpl.listOfShop(id);
		if(shopList==null)
			return new ResponseEntity<>(shopList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(shopList,HttpStatus.OK);
	}
	
	@GetMapping("/plotlist/{id}")
	public ResponseEntity<?> listOfPlot(@PathVariable("id") long id) throws BrokerException{
		List<Plot> plotList= brokerServiceImpl.listOfPlot(id);
		if(plotList==null)
			return new ResponseEntity<>(plotList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(plotList,HttpStatus.OK);
	}
	
	@GetMapping("/customerlist/{id}")
	public ResponseEntity<?> listOfCustomers(@PathVariable("id") long id) throws BrokerException{
		List<Customer> customerList= brokerServiceImpl.listOfCustomers(id);
		if(customerList==null)
			return new ResponseEntity<>(customerList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customerList,HttpStatus.OK);
	}
	
	

	

}
