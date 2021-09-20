package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.AddressException;
import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.repository.AddressRepository;
import com.cg.rebapi.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address addAddress(Address address) {
		if(address.getStreetName().isEmpty()||address.getPincode().length()==0)
			throw new EmptyFieldException("601", "Input feilds are empty");
		Address a= addressRepository.save(address);
		return a;
	}
	@Override
	public Address deleteAddress(long id) throws AddressException  {
		if(addressRepository.existsById(id)) {
		Address a=addressRepository.findById(id).get();
		addressRepository.deleteById(id);
		return a;
		}
		throw new AddressException("Address with id "+id + " is not there to delete");
	}
	
	public boolean checkAddress(long id) {
		if(addressRepository.existsById(id))
			return true;
		return false;
		
	}
	@Override
	public Address getAddress(long id) throws AddressException {
		// TODO Auto-generated method stub
		if(addressRepository.existsById(id)) {
		Address address=addressRepository.findById(id).get();
		return address;
		}
		throw new AddressException("Address with id "+id+" is not present");
		
	}
	@Override
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		List<Address> addresses=addressRepository.findAll();
		if(addresses.isEmpty())
			throw new EmptyListException();
		return addresses;
	}

	
	


}
