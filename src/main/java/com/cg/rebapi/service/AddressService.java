package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.AddressException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Broker;

public interface AddressService {
	public Address addAddress(Address address);
	public Address deleteAddress(long id) throws AddressException;
	public Address getAddress(long id) throws AddressException;
	public boolean checkAddress(long id);
	public List<Address> getAddresses();

}
