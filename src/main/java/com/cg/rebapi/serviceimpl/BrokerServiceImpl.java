package com.cg.rebapi.serviceimpl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.CustomerException;
import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.repository.BrokerRepository;
import com.cg.rebapi.service.BrokerService;

@Service
public class BrokerServiceImpl implements BrokerService{
	
	@Autowired
	BrokerRepository brokerRepository;
	@Override
	public List<Broker> listOfBrokers(){
		List<Broker> brokers=brokerRepository.findAll();
		if(brokers.isEmpty())
			throw new EmptyListException();
		return brokers;
		
	}
	@Override
	public Broker addBroker(Broker broker) {
		if(broker.getBrokerFirstName().isEmpty()||broker.getBrokerLastName().length()==0)
			throw new EmptyFieldException("601", "Input feilds are empty");
		Broker b= brokerRepository.save(broker);
		return b;
	}
	

	@Override
	public Broker deleteBroker(long id) throws BrokerException  {
		if(brokerRepository.existsById(id)) {
		Broker b=brokerRepository.findById(id).get();
		brokerRepository.deleteById(id);
		return b;
		}
		throw new BrokerException("Broker with id "+id + " is not there to delete");
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
		throw new BrokerException("Broker with id "+id+" is not there to update");
	}
	
	@Override
	public List<Flat> listOfFlat(long id)throws BrokerException{
		if(brokerRepository.existsById(id)) {
			Broker broker= brokerRepository.findById(id).get();
			List<Flat> flatList= broker.getFlatList();
			if(flatList.size()==0)
				throw new EmptyListException();
			return flatList;
		}
		throw new BrokerException("Broker with id "+id+" is not found");
	}

	@Override
	public List<Shop> listOfShop(long id)throws BrokerException{
		if(brokerRepository.existsById(id)) {
			Broker broker= brokerRepository.findById(id).get();
			List<Shop> shopList= broker.getShopList();
			if(shopList.size()==0)
				throw new EmptyListException();
			return shopList;
		}
		throw new BrokerException("Broker with id "+id+" is not found");
	}
	
	@Override
	public List<Plot> listOfPlot(long id)throws BrokerException{
		if(brokerRepository.existsById(id)) {
			Broker broker=brokerRepository.findById(id).get();
			List<Plot> plotList= broker.getPlotList();
			if(plotList.size()==0)
				throw new EmptyListException();
			return plotList;
		}
		throw new BrokerException("Customer with id "+id+" is not found");
	}

	
	
}
