package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	public List<Customer> listOfCustomer();
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int id);


}
