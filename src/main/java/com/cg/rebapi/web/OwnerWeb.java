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
import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.exception.OwnerException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Owner;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
import com.cg.rebapi.serviceimpl.OwnerServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("api/owners")
public class OwnerWeb {
	
	@Autowired
	public OwnerServiceImpl ownerServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getOwners(){
		List<Owner> ownerList= ownerServiceImpl.listOfOwners();
		if(ownerList==null)
			return new ResponseEntity<>(ownerList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ownerList,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addOrUpdateOwner(@Valid @RequestBody Owner owner, BindingResult bindingResult) throws MethodArgumentsNotValidException {
//		if(bindingResult.hasErrors()) {
//			throw new MethodArgumentsNotValidException();
//		}
//		if(owner.getOwnerAddress()==null)
//			return new ResponseEntity<String>("Owner should have address, please provide address" , HttpStatus.NOT_ACCEPTABLE);
		Address address=addressServiceImpl.addAddress(owner.getOwnerAddress());
		Owner ownerSaved=ownerServiceImpl.addOwner(owner);
		return new ResponseEntity<Owner>(ownerSaved, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOwner(@PathVariable("id") long id) throws OwnerException{
		Owner owner= ownerServiceImpl.getOwner(id);
		if(owner==null)
			return new ResponseEntity<>(owner,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(owner,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOwner(@PathVariable("id") long bno) throws OwnerException{
		Owner ownerSaved=ownerServiceImpl.deleteOwner(bno);
		if(ownerSaved==null)
			return new ResponseEntity<>(ownerSaved,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ownerSaved,HttpStatus.OK);
	}
	
	@GetMapping("/flatlist/{id}")
	public ResponseEntity<?> listOfFlat(@PathVariable("id") long id) throws OwnerException{
		List<Flat> flatList= ownerServiceImpl.listOfFlat(id);
		if(flatList==null)
			return new ResponseEntity<>(flatList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(flatList,HttpStatus.OK);
	}
	
	@GetMapping("/shoplist/{id}")
	public ResponseEntity<?> listOfShop(@PathVariable("id") long id) throws BrokerException, OwnerException{
		List<Shop> shopList= ownerServiceImpl.listOfShop(id);
		if(shopList==null)
			return new ResponseEntity<>(shopList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(shopList,HttpStatus.OK);
	}
	
	@GetMapping("/plotlist/{id}")
	public ResponseEntity<?> listOfPlot(@PathVariable("id") long id) throws OwnerException {
		List<Plot> plotList= ownerServiceImpl.listOfPlot(id);
		if(plotList==null)
			return new ResponseEntity<>(plotList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(plotList,HttpStatus.OK);
	}
	@GetMapping("/customerlist/{id}")
	public ResponseEntity<?> listOfCustomers(@PathVariable("id") long id) throws BrokerException{
		List<Customer> customerList= ownerServiceImpl.listOfCustomers(id);
		if(customerList==null)
			return new ResponseEntity<>(customerList,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customerList,HttpStatus.OK);
	}
	
	

}
