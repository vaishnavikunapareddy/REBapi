package com.cg.rebapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.exception.FlatException;
import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.repository.FlatRepository;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
import com.cg.rebapi.serviceimpl.FlatServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("api/flats")
public class FlatWeb {
	@Autowired
	public FlatServiceImpl flatServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getFlats(){
		List<Flat> flatList= flatServiceImpl.listOfFlats();
		if(flatList==null)
			return new ResponseEntity<>(flatList,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(flatList,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addOrUpdateFlat(@Valid @RequestBody Flat flat, BindingResult bindingResult) throws MethodArgumentsNotValidException {
//		if(bindingResult.hasErrors()) {
//			throw new MethodArgumentsNotValidException();
//		}
//		if(flat.getFlatAddress()==null)
//			return new ResponseEntity<String>("Flat should have address, please provide address" , HttpStatus.NOT_ACCEPTABLE);
//		
//		if(addressServiceImpl.checkAddress(flat.getFlatAddress().getId())) {
		        Address address=addressServiceImpl.addAddress(flat.getFlatAddress());
      			Flat flatSaved=flatServiceImpl.addFlat(flat);
				return new ResponseEntity<Flat>(flatSaved, HttpStatus.CREATED);
//		}
//		return new ResponseEntity<String>("flat cannot be added, Address id "+flat.getFlatAddress().getId()+ " not found" , HttpStatus.NOT_ACCEPTABLE);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getFlat(@PathVariable("id") long id) throws FlatException{
		Flat flat= flatServiceImpl.getFlat(id);
		if(flat==null)
			return new ResponseEntity<>(flat,HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(flat,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFlat(@PathVariable("id") long bno) throws FlatException{
		Flat flatSaved=flatServiceImpl.deleteFlat(bno);
		if(flatSaved==null)
			return new ResponseEntity<>(flatSaved,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(flatSaved,HttpStatus.OK);
	}
	
	
	@GetMapping("getstatus/{status}")
	public ResponseEntity<?> getFlatStatus(@PathVariable("status") String status){
		List<Flat> flatList= flatServiceImpl.getFlatStatus(status);
		if(flatList==null)
			return new ResponseEntity<>(flatList,HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(flatList,HttpStatus.OK);
	}

	
	
	

}