package com.cg.rebapi.service;

import java.util.List;


import com.cg.rebapi.exception.OwnerException;
import com.cg.rebapi.model.Owner;

public interface OwnerService {
	
	public Owner addOwner(Owner owner);
	public List<Owner> listOfOwners();
	public Owner deleteOwner(long id) throws OwnerException;
	public boolean checkOwner(long id);
	public Owner getOwner(long id) throws OwnerException;

}
