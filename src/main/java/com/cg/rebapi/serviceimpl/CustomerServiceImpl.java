package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.Customer;
import com.cg.rebapi.repository.CustomerRepository;
import com.cg.rebapi.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	
		@Autowired
		CustomerRepository customerRepository;
		@Override
		public List<Customer> listOfCustomer(){
			List<Customer> customers=customerRepository.findAll();
			return customers;
			
		}
		@Override
		public Customer addCustomer(Customer customer) {
			Customer c=  customerRepository.save(customer);
			return c;
		}
		@Override
		public Customer updateCustomer(Customer customer) {
			return  customerRepository.save(customer);
		}
		@Override
		public Customer deleteCustomer(int id) {
			Customer c= customerRepository.findById(id).get();
			customerRepository.deleteById(id);
			return c;
		}
		
		public boolean checkCustomer(int id) {
			if(customerRepository.existsById(id))
				return true;
			return false;
			
		}

		
		
}
