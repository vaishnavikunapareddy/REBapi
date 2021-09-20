package com.cg.rebapi.service;

import com.cg.rebapi.model.Address;

public interface AddressService {
	public Address addAddress(Address address);
	public Address updateAddress(Address address);
	public Address deleteAddress(int streetNo);

}
