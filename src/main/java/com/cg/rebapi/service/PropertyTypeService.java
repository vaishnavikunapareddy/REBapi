package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.PropertyType;

public interface PropertyTypeService {
	public List<PropertyType> getProperties();
	public PropertyType deleteProperty(PropertyType property);
	public PropertyType addProperty(PropertyType property);
	public PropertyType getProperty(Long id);
	public boolean checkPropertyType(Long id);

}
