package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.AddressException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Broker;

public interface AddressService {
	/* Creating the Address*/
	public Address addAddress(Address address);
	/* Deleting the Address*/
	public Address deleteAddress(long id) throws AddressException;
	/* Getting particular  Address*/
	public Address getAddress(long id) throws AddressException;
	/* Validating the Address*/
	public boolean checkAddress(long id);
	/* Getting all the Addresses*/
	public List<Address> getAddresses();

}
