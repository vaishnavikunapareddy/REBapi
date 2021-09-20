package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.OwnerException;

import com.cg.rebapi.model.Owner;
import com.cg.rebapi.serviceimpl.OwnerServiceImpl;

@RestController
@RequestMapping("/owners")
public class OwnerWeb {
	
	@Autowired
	public OwnerServiceImpl ownerService;
	
	@GetMapping("/getowners")
	public ResponseEntity<?> getOwners(){
		List<Owner> brokerList= ownerService.listOfOwners();
		return new ResponseEntity<>(brokerList,HttpStatus.OK);
	}
	
	@PostMapping("/addowner")
	public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
		Owner ownerSaved=ownerService.addOwner(owner);
		return new ResponseEntity<Owner>(ownerSaved, HttpStatus.CREATED);
	}
	@GetMapping("/ownerlist/{id}")
	public ResponseEntity<?> getBroker(@PathVariable("id") long id){
		List<Owner> brokerList= ownerService.listOfOwners();
		return new ResponseEntity<>(brokerList,HttpStatus.OK);
		
	}
	@DeleteMapping("/deletebroker/{id}")
	public ResponseEntity<?> deleteBroker(@PathVariable("id") long bno) throws OwnerException{
		Owner ownerSaved=ownerService.deleteOwner(bno);
		return new ResponseEntity<>(ownerSaved,HttpStatus.OK);
	}
	
	
	

}
