package com.cg.rebapi.serviceimpl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.model.Broker;
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
		if(broker.getBrokerFirstName().isEmpty()||broker.getBrokerFirstName().length()==0)
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
		// TODO Auto-generated method stub
		if(brokerRepository.existsById(id)) {
			Broker b=brokerRepository.findById(id).get();
			return b;
		}
		throw new BrokerException("Broker with id "+id+" is not there to update");
	}

	
	
}
