package com.cg.rebapi.serviceimpl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.repository.AddressRepository;
import com.cg.rebapi.repository.BrokerRepository;
import com.cg.rebapi.service.BrokerService;

@Service
public class BrokerServiceImpl implements BrokerService{
	
	@Autowired
	BrokerRepository brokerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	@Override
	public List<Broker> listOfBrokers(){
		List<Broker> brokers=brokerRepository.findAll();
		if(brokers.isEmpty())
//			throw new EmptyListException();
			return null;
		
		return brokers;		
	}
	
	@Override
	public Broker addBroker(Broker broker) {
		Broker b= brokerRepository.save(broker);
		return b;
	}
	

	@Override
	public Broker deleteBroker(long id) throws BrokerException  {
		if(brokerRepository.existsById(id)) {
		Broker b=brokerRepository.findById(id).get();
		addressRepository.deleteById(b.getBrokerAddress().getId());
		brokerRepository.deleteById(id);
		return b;
		}
		//throw new BrokerException("Broker with id "+id + " is not there to delete");
		return null;
	}
	@Override
	public boolean checkBroker(long id) {
		if(brokerRepository.existsById(id))
			return true;
		return false;
		
	}

	@Override
	public Broker getBroker(long id) throws BrokerException{
		
		if(brokerRepository.existsById(id)) {
			Broker b=brokerRepository.findById(id).get();
			
			return b;
		}
		//throw new BrokerException("Broker with id "+id+" is not found");
		return null;
	}
	
	@Override
	public List<Flat> listOfFlat(long id)throws BrokerException{
		if(brokerRepository.existsById(id)) {
			Broker broker= brokerRepository.findById(id).get();
			List<Flat> flatList= broker.getFlatList();
			if(flatList.isEmpty())
				//throw new EmptyListException();
				return null;
			return flatList;
		}
		//throw new BrokerException("Broker with id "+id+" was not found");
		return null;
	}

	@Override
	public List<Shop> listOfShop(long id)throws BrokerException{
		if(brokerRepository.existsById(id)) {
			Broker broker= brokerRepository.findById(id).get();
			List<Shop> shopList= broker.getShopList();
			if(shopList.isEmpty())
				//throw new EmptyListException();
				return null;
			return shopList;
		}
		//throw new BrokerException("Broker with id "+id+" is not found");
		return null;
	}
	
	@Override
	public List<Plot> listOfPlot(long id)throws BrokerException{
		if(brokerRepository.existsById(id)) {
			Broker broker=brokerRepository.findById(id).get();
			List<Plot> plotList= broker.getPlotList();
			if(plotList.isEmpty())
				//throw new EmptyListException();
				return null;
			return plotList;
		}
		//throw new BrokerException("Customer with id "+id+" is not found");
		return null;
	}
	
	public List<Customer> listOfCustomers(long id){
		if(brokerRepository.existsById(id)) {
			Broker broker=brokerRepository.findById(id).get();
			List<Customer> customerList= broker.getCustomerList();
			if(customerList.isEmpty())
				//throw new EmptyListException();
				return null;
			return customerList;
			
		}
		return null;
	}


	
	
}
