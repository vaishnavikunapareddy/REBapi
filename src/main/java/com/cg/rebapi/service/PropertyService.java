package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.PropertyException;
import com.cg.rebapi.model.Property;


public interface PropertyService {
	
	public Property deleteProperty(long id) throws PropertyException;

	public List<Property> getProperties();

	public boolean checkProperty(long id);

	public Property getProperty(long id) throws PropertyException;
	

}
