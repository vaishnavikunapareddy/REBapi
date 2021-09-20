package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.PropertyType;
import com.cg.rebapi.repository.PropertyTypeRepository;
import com.cg.rebapi.service.PropertyTypeService;
@Service
public class PropertyTypeServiceImpl implements PropertyTypeService{
	
	@Autowired
	public PropertyTypeRepository propertyRepository;

	@Override
	public List<PropertyType> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyType deleteProperty(PropertyType property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyType addProperty(PropertyType property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyType getProperty(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkPropertyType(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
