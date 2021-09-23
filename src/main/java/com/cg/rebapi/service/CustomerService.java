package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;

public interface CustomerService {
	

		
		public Customer addCustomer(Customer customer);
		public List<Customer> listOfCustomers();
		public Customer deleteCustomer(long id) throws CustomerException;
		public boolean checkCustomer(long id);
		public Customer getCustomer(long id) throws CustomerException;
		public List<Flat> listOfFlat(long id) throws CustomerException;
		public List<Shop> listOfShop(long id) throws CustomerException;
		public List<Plot> listOfPlot(long id) throws CustomerException;


	

}
