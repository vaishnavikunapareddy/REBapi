package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.Property;

public interface PropertyService {
	public List<Property> getProperties();
	public Property deleteProperty(Property property);
	public Property addProperty(Property property);
	public Property getProperty(Long id);
	public boolean checkProperty(Long id);
	

}
