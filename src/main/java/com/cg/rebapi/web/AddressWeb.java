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

import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.repository.AddressRepository;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;

@RestController
@RequestMapping("/addresses")
public class AddressWeb {
	@Autowired
	public AddressServiceImpl addressService;
	@Autowired
	public AddressRepository addressRepository;
	
	@PostMapping("/addaddress")
	public Address addEmployee(@RequestBody Address address) {
		Address a= addressService.addAddress(address);
		return a;
	}
	
	@DeleteMapping("/deleteaddress/{id}")
	public Address deleteBroker(@PathVariable("id") int streetNo) {
		if(addressService.checkAddress(streetNo)) {
			return addressService.deleteAddress(streetNo);
		}
		return null;
	}

	
	@PutMapping("/updateaddress")
	public Address updateBroker(@RequestBody Address address) {
		
		if(addressService.checkAddress(address.getStreetNo())) {
			return addressService.updateAddress(address);
		}
		return null;
		
	}
	
	@GetMapping("/addresses")
	public List<Address> getListOfAddress(){
		
		return addressRepository.findAll();
	}
		
	

	

}
