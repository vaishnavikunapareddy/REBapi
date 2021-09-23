package com.cg.rebapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.exception.OwnerException;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Owner;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.serviceimpl.OwnerServiceImpl;

@RestController
@RequestMapping("api/owners")
public class OwnerWeb {
	
	@Autowired
	public OwnerServiceImpl ownerServiceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getOwners(){
		List<Owner> brokerList= ownerServiceImpl.listOfOwners();
		return new ResponseEntity<>(brokerList,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addOrUpdateOwner(@Valid @RequestBody Owner owner, BindingResult bindingResult) throws MethodArgumentsNotValidException {
		if(bindingResult.hasErrors()) {
			throw new MethodArgumentsNotValidException();
		}
		if(owner.getOwnerAddress()==null)
			return new ResponseEntity<String>("Owner should have address, please provide address" , HttpStatus.NOT_ACCEPTABLE);
		Owner ownerSaved=ownerServiceImpl.addOwner(owner);
		return new ResponseEntity<Owner>(ownerSaved, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBroker(@PathVariable("id") long id){
		List<Owner> brokerList= ownerServiceImpl.listOfOwners();
		return new ResponseEntity<>(brokerList,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBroker(@PathVariable("id") long bno) throws OwnerException{
		Owner ownerSaved=ownerServiceImpl.deleteOwner(bno);
		return new ResponseEntity<>(ownerSaved,HttpStatus.OK);
	}
	
	@GetMapping("/flatlist/{id}")
	public ResponseEntity<?> listOfFlat(@PathVariable("id") long id) throws OwnerException{
		List<Flat> flatList= ownerServiceImpl.listOfFlat(id);
		return new ResponseEntity<>(flatList,HttpStatus.OK);
	}
	
	@GetMapping("/shoplist/{id}")
	public ResponseEntity<?> listOfShop(@PathVariable("id") long id) throws BrokerException, OwnerException{
		List<Shop> shopList= ownerServiceImpl.listOfShop(id);
		return new ResponseEntity<>(shopList,HttpStatus.OK);
	}
	
	@GetMapping("/plotlist/{id}")
	public ResponseEntity<?> listOfPlot(@PathVariable("id") long id) throws OwnerException {
		List<Plot> plotList= ownerServiceImpl.listOfPlot(id);
		return new ResponseEntity<>(plotList,HttpStatus.OK);
	}
	
	

}
