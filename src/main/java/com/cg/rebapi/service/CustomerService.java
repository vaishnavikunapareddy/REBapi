package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.model.Customer;

public interface CustomerService {
	

		
		public Customer addCustomer(Customer customer);
		public List<Customer> listOfCustomers();
		public Customer deleteCustomer(long id) throws CustomerException;
		public boolean checkCustomer(long id);
		public Customer getCustomer(long id) throws CustomerException;


	

}
