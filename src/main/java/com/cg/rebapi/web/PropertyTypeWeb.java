package com.cg.rebapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.serviceimpl.PropertyTypeServiceImpl;

@RestController
public class PropertyTypeWeb {
	@Autowired
	public PropertyTypeServiceImpl propertyTypeService;
	
	

}
