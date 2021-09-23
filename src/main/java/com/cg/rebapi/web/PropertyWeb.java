package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.PropertyException;
import com.cg.rebapi.model.Property;
import com.cg.rebapi.serviceimpl.PropertyServiceImpl;

@RestController
@RequestMapping("api/properties")
public class PropertyWeb {
	
	@Autowired
	public PropertyServiceImpl propertyService;
	@GetMapping("")
	public ResponseEntity<?> getPropertiess(){
		List<Property> propertyList= propertyService.getProperties();
		return new ResponseEntity<>(propertyList,HttpStatus.OK);
	}
	
//	@PostMapping("/addplot")
//	public ResponseEntity<Plot> addPlot(@RequestBody Plot plot) {
//		Plot plotSaved=plotService.addPlot(plot);
//		return new ResponseEntity<Plot>(plotSaved, HttpStatus.CREATED);
//	}
	@GetMapping("/getproperty/{id}")
	public ResponseEntity<?> getProperty(@PathVariable("id") long id){
		List<Property> propertyList= propertyService.getProperties();
		return new ResponseEntity<>(propertyList,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteplot/{id}")
	public ResponseEntity<?> deletePlot(@PathVariable("id") long bno) throws PropertyException{
		Property propertyDeleted=propertyService.deleteProperty(bno);
		return new ResponseEntity<>(propertyDeleted,HttpStatus.OK);
	}
	

}