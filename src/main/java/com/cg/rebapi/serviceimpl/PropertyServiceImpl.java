package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.exception.PropertyException;
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
		List<Property> properties=propertyRepository.findAll();
		if(properties.isEmpty())
			throw new EmptyListException();
		return properties;
		
	}

	@Override
	public Property deleteProperty(long id) throws PropertyException {
		// TODO Auto-generated method stub
		if(propertyRepository.existsById(id)) {
			Property p=propertyRepository.findById(id).get();
			propertyRepository.deleteById(id);
			return p;
			}
			throw new PropertyException("Property with id "+id + " is not there to delete");
	}

	@Override
	public boolean checkProperty(long id) {
		// TODO Auto-generated method stub
		if(propertyRepository.existsById(id))
			return true;
		return false;
		
	}

	@Override
	public Property getProperty(long id) throws PropertyException {
		if(propertyRepository.existsById(id)) {
			Property p=propertyRepository.findById(id).get();
			return p;
		}
		throw new PropertyException("Property with id "+id+" is not there to update");	}

//	@Override
//	public Property addProperty(Property property) {
//		// TODO Auto-generated method stub
//		Property p=propertyRepository.save(property);
//		return p;
//	}
//
//	
	

	
}