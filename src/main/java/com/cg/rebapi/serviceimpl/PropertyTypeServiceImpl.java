package com.cg.rebapi.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.exception.PropertyTypeException;
import com.cg.rebapi.model.PropertyType;
import com.cg.rebapi.repository.PropertyTypeRepository;
import com.cg.rebapi.service.PropertyTypeService;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService{
	@Autowired
	public PropertyTypeRepository propertyTypeRepository;
	
	
	@Override
	public List<PropertyType> getPropertyTypes() {
			List<PropertyType> propertyTypes=propertyTypeRepository.findAll();
				if(propertyTypes.isEmpty())
					throw new EmptyListException();
				return propertyTypes;
				
	}

	@Override
	public PropertyType deletePropertyType(long id) throws PropertyTypeException {
	
		if(propertyTypeRepository.existsById(id)) {
			PropertyType p=propertyTypeRepository.findById(id).get();
			propertyTypeRepository.deleteById(id);
			return p;
			}
			throw new PropertyTypeException("PropertyType with id "+id + " is not there to delete");
	}

	

	@Override
	public boolean checkPropertyType(long id) {
		
		if(propertyTypeRepository.existsById(id))
			return true;
		return false;
		
	}

	@Override
	public PropertyType getPropertyType(long id) throws PropertyTypeException {
		
		if(propertyTypeRepository.existsById(id)) {
			PropertyType p=propertyTypeRepository.findById(id).get();
			return p;
		}
		throw new PropertyTypeException("PropertyType with id "+id+" is not there to update");
	}
	
	

}