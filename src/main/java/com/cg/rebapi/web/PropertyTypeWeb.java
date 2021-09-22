package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.PropertyTypeException;
import com.cg.rebapi.model.Property;
import com.cg.rebapi.model.PropertyType;
import com.cg.rebapi.serviceimpl.PropertyTypeServiceImpl;

@RestController
public class PropertyTypeWeb {
	
	@Autowired
	public PropertyTypeServiceImpl propertyTypeService;
	@GetMapping("")
	public ResponseEntity<?> getPropertyTypes(){
		List<PropertyType> propertyList= propertyTypeService.getPropertyTypes();
		return new ResponseEntity<>(propertyList,HttpStatus.OK);
	}
	
//	@PostMapping("")
//	public ResponseEntity<Plot> addPropertyType(@RequestBody PropertType propertyType) {
//		Plot plotSaved=plotService.addPlot(plot);
//		return new ResponseEntity<Plot>(plotSaved, HttpStatus.CREATED);
//	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getPropertyType(@PathVariable("id") long id) throws PropertyTypeException{
		PropertyType propertyTypeList= propertyTypeService.getPropertyType(id);
		return new ResponseEntity<>(propertyTypeList,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePropertyType(@PathVariable("id") long bno) throws PropertyTypeException{
		PropertyType propertyTypeDeleted=propertyTypeService.deletePropertyType(bno);
		return new ResponseEntity<>(propertyTypeDeleted,HttpStatus.OK);
	}
	

}