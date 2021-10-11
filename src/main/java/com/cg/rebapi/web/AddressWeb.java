package com.cg.rebapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.AddressException;
import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.repository.AddressRepository;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("api/addresses")
public class AddressWeb {
	@Autowired
	public AddressServiceImpl addressService;
	@GetMapping("")
	public ResponseEntity<?> getAddresses(){
		List<Address> addressList= addressService.getAddresses();
		if(addressList==null)
			return new ResponseEntity<>(addressList,HttpStatus.NOT_FOUND);
			
		
		return new ResponseEntity<>(addressList,HttpStatus.OK);
	}
	
	@PostMapping("/addaddress")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address) {
		Address addressSaved=addressService.addAddress(address);
		if(addressSaved==null)
			return new ResponseEntity<Address>(addressSaved, HttpStatus.NOT_ACCEPTABLE);

			
		return new ResponseEntity<Address>(addressSaved, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getAddress(@PathVariable("id") long id) throws AddressException{
		Address address = addressService.getAddress(id);
		if(address==null)
			return new ResponseEntity<>(address,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(address,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteaddress(@PathVariable("id") long id) throws AddressException{
		Address addressSaved=addressService.deleteAddress(id);
		if(addressSaved==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
	

	

}
