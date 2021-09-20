package com.cg.rebapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.serviceimpl.PropertyServiceImpl;

@RestController
public class PropertyWeb {
	
	@Autowired
	public PropertyServiceImpl propertyService;
	

}
