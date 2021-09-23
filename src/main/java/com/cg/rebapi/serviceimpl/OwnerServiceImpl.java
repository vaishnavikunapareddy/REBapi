package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.exception.OwnerException;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Owner;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.repository.OwnerRepository;
import com.cg.rebapi.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	public OwnerRepository ownerRepository;

	@Override
	public List<Owner> listOfOwners(){
		List<Owner> owners=ownerRepository.findAll();
		if(owners.isEmpty())
			throw new EmptyListException();
		return owners;
		
	}
	@Override
	public Owner addOwner(Owner owner) {
		if(owner.getFirstName().isEmpty()||owner.getFirstName().length()==0)
			throw new EmptyFieldException("601", "Input feilds are empty");
		Owner b= ownerRepository.save(owner);
		return b;
	}
	

	@Override
	public Owner deleteOwner(long id) throws OwnerException  {
		if(ownerRepository.existsById(id)) {
		Owner b=ownerRepository.findById(id).get();
		ownerRepository.deleteById(id);
		return b;
		}
		throw new OwnerException("Owner with id "+id + " is not there to delete");
	}
	@Override
	public boolean checkOwner(long id) {
		if(ownerRepository.existsById(id))
			return true;
		return false;
		
	}
	@Override
	public Owner getOwner(long id) throws OwnerException {
		
		if(ownerRepository.existsById(id)) {
			Owner o=ownerRepository.findById(id).get();
			return o;
		}
		throw new OwnerException("Owner with id "+id+" is not there to update");	
	}

	@Override
	public List<Flat> listOfFlat(long id)throws OwnerException{
		if(ownerRepository.existsById(id)) {
			Owner owner= ownerRepository.findById(id).get();
			List<Flat> flatList= owner.getFlatList();
			if(flatList.size()==0)
				throw new EmptyListException();
			return flatList;
		}
		throw new OwnerException("Broker with id "+id+" is not found");
	}

	@Override
	public List<Shop> listOfShop(long id)throws OwnerException{
		if(ownerRepository.existsById(id)) {
			Owner owner= ownerRepository.findById(id).get();
			List<Shop> shopList= owner.getShopList();
			if(shopList.size()==0)
				throw new EmptyListException();
			return shopList;
		}
		throw new OwnerException("Broker with id "+id+" is not found");
	}
	
	@Override
	public List<Plot> listOfPlot(long id)throws OwnerException{
		if(ownerRepository.existsById(id)) {
			Owner owner=ownerRepository.findById(id).get();
			List<Plot> plotList= owner.getPlotList();
			if(plotList.size()==0)
				throw new EmptyListException();
			return plotList;
		}
		throw new OwnerException("Customer with id "+id+" is not found");
	}


	
}
