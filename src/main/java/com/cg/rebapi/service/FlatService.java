package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.FlatException;
import com.cg.rebapi.model.Flat;


public interface FlatService {

	public List<Flat> listOfFlats();

	public Flat addFlat(Flat flat);

	public Flat deleteFlat(long id) throws FlatException;

	public boolean checkFlat(long id);

	public Flat getFlat(long id) throws FlatException;
	
	

	public List<Flat> getFlatStatus(String status);

}
