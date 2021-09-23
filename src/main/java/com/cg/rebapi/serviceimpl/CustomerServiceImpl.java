package com.cg.rebapi.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.repository.CustomerRepository;
import com.cg.rebapi.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public List<Customer> listOfCustomers(){
		List<Customer> customers=customerRepository.findAll();
		if(customers.isEmpty())
			throw new EmptyListException();
		return customers;
		
	}
	@Override
	public Customer addCustomer(Customer customer) {
		if(customer.getCustomerFirstName().isEmpty()||customer.getCustomerFirstName().length()==0)
			throw new EmptyFieldException("601", "Input feilds are empty");
		Customer c= customerRepository.save(customer);
		return c;
	}
	

	@Override
	public Customer deleteCustomer(long id) throws CustomerException  {
		if(customerRepository.existsById(id)) {
			Customer c=customerRepository.findById(id).get();
			customerRepository.deleteById(id);
		return c;
		}
		throw new CustomerException("Customer with id "+id + " is not there to delete");
	}
	@Override
	public boolean checkCustomer(long id) {
		if(customerRepository.existsById(id))
			return true;
		return false;
		
	}

	@Override
	public Customer getCustomer(long id) throws CustomerException{
		
		if(customerRepository.existsById(id)) {
			Customer customer=customerRepository.findById(id).get();
			return customer;
		}
		throw new CustomerException("Customer with id "+id+" is not found");
	}
	@Override
	public List<Flat> listOfFlat(long id)throws CustomerException{
		if(customerRepository.existsById(id)) {
			Customer customer=customerRepository.findById(id).get();
			List<Flat> flatList= customer.getFlatList();
			if(flatList.size()==0)
				throw new EmptyListException();
			return flatList;
		}
		throw new CustomerException("Customer with id "+id+" is not found");
	}

	@Override
	public List<Shop> listOfShop(long id)throws CustomerException{
		if(customerRepository.existsById(id)) {
			Customer customer=customerRepository.findById(id).get();
			List<Shop> shopList= customer.getShopList();
			if(shopList.size()==0)
				throw new EmptyListException();
			return shopList;
		}
		throw new CustomerException("Customer with id "+id+" is not found");
	}
	
	@Override
	public List<Plot> listOfPlot(long id)throws CustomerException{
		if(customerRepository.existsById(id)) {
			Customer customer=customerRepository.findById(id).get();
			List<Plot> plotList= customer.getPlotList();
			if(plotList.size()==0)
				throw new EmptyListException();
			return plotList;
		}
		throw new CustomerException("Customer with id "+id+" is not found");
	}

	
		
		
}