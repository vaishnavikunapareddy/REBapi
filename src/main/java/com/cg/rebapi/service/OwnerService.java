package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.OwnerException;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Owner;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;

public interface OwnerService {
	
	public Owner addOwner(Owner owner);
	public List<Owner> listOfOwners();
	public Owner deleteOwner(long id) throws OwnerException;
	public boolean checkOwner(long id);
	public Owner getOwner(long id) throws OwnerException;
	public List<Flat> listOfFlat(long id) throws OwnerException;
	public List<Shop> listOfShop(long id) throws OwnerException;
	public List<Plot> listOfPlot(long id) throws OwnerException;

}
