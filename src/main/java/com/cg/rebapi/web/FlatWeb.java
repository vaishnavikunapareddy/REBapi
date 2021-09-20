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

import com.cg.rebapi.exception.FlatException;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.serviceimpl.FlatServiceImpl;


@RestController
@RequestMapping("/flats")
public class FlatWeb {
	
	@Autowired
	public FlatServiceImpl flatService;
	
	@GetMapping("/getflats")
	public ResponseEntity<?> getFlags(){
		List<Flat> flatList= flatService.listOfFlats();
		return new ResponseEntity<>(flatList,HttpStatus.OK);
	}
	
	@PostMapping("/addflat")
	public ResponseEntity<Flat> addFlat(@RequestBody Flat flat) {
		Flat flatSaved=flatService.addFlat(flat);
		return new ResponseEntity<Flat>(flatSaved, HttpStatus.CREATED);
	}
	@GetMapping("/getflat/{id}")
	public ResponseEntity<?> getFlat(@PathVariable("id") long id){
		List<Flat> flatList= flatService.listOfFlats();
		return new ResponseEntity<>(flatList,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteflat/{id}")
	public ResponseEntity<?> deleteFlat(@PathVariable("id") long bno) throws FlatException{
		Flat flatSaved=flatService.deleteFlat(bno);
		return new ResponseEntity<>(flatSaved,HttpStatus.OK);
	}
	
	

}