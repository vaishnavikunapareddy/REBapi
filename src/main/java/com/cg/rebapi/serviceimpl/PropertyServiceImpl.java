package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.Property;
import com.cg.rebapi.repository.PropertyRepository;
import com.cg.rebapi.service.PropertyService;
@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	public PropertyRepository propertyRepository;

	@Override
	public List<Property> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property deleteProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property addProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property getProperty(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkProperty(Long id) {
		// TODO Auto-generated method stub
		return false;
	};

}
