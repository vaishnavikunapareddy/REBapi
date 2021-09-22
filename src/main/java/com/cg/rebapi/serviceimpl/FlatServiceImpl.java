package com.cg.rebapi.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.exception.FlatException;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.repository.FlatRepository;
import com.cg.rebapi.service.FlatService;



@Service
public class FlatServiceImpl implements FlatService{
	
	@Autowired
	FlatRepository flatRepository;
	
	@Override
	public List<Flat> listOfFlats() throws EmptyListException{
		List<Flat> flatList=flatRepository.findAll();
		if(flatList.isEmpty())
			throw new EmptyListException();
		return flatList;
		
	}
	@Override
	public Flat addFlat(Flat flat) {
		if(flat.getFlatName().isEmpty()||flat.getFlatName().length()==0)
			throw new EmptyFieldException("601", "Input feilds are empty");
		Flat f= flatRepository.save(flat);
		return f;
	}
	

	@Override
	public Flat deleteFlat(long id) throws FlatException  {
		if(flatRepository.existsById(id)) {
		Flat f=flatRepository.findById(id).get();
		flatRepository.deleteById(id);
		return f;
		}
		throw new FlatException("Flat with id "+id + " is not there to delete");
	}
	@Override
	public boolean checkFlat(long id) {
		if(flatRepository.existsById(id))
			return true;
		return false;
		
	}

	@Override
	public Flat getFlat(long id) throws FlatException{
		// TODO Auto-generated method stub
		if(flatRepository.existsById(id)) {
			Flat f=flatRepository.findById(id).get();
			return f;
		}
		throw new FlatException("Flat with id "+id+" is not there to update");
	}
	@Override
	public List<Flat> getFlatStatus(String status){
		List<Flat> flatList=flatRepository.getFlatStatus(status);
		if(flatList.isEmpty())
			throw new EmptyListException();
		return flatList;
		
	}

		
		
}