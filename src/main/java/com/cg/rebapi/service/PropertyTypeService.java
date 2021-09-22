package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.PropertyTypeException;
import com.cg.rebapi.model.PropertyType;


public interface PropertyTypeService {
	
	public List<PropertyType> getPropertyTypes();
	public PropertyType deletePropertyType(long id) throws PropertyTypeException;
	public boolean checkPropertyType(long id);
	public PropertyType getPropertyType(long id) throws PropertyTypeException;

}
