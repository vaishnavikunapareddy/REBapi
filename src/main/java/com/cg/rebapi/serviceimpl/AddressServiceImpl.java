package com.cg.rebapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Address a=addressRepository.save(address);
		return a;
	}

	@Override
	public Address deleteAddress(int streetNo) {
		Address a=addressRepository.findById(streetNo).get();
		addressRepository.deleteById(streetNo);
		return a;

	}

	@Override
	public Address updateAddress(Address address) {
		
		return addressRepository.save(address);
	}

	public boolean checkAddress(int id) {
		if(addressRepository.existsById(id))
			return true;
		return false;
		
	}

	
	


}
