package com.cg.rebapi.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.Broker;
import com.cg.rebapi.repository.BrokerRepository;
import com.cg.rebapi.service.BrokerService;

@Service
public class BrokerServiceImpl implements BrokerService{
	@Autowired
	BrokerRepository brokerRepository;
	
	public List<Broker> listOfBrokers(){
		List<Broker> brokers=brokerRepository.findAll();
		return brokers;
		
	}
	
	public Broker addBroker(Broker broker) {
		Broker b= brokerRepository.save(broker);
		return b;
	}
	
	
	public Broker deleteBroker(int id) {
		Broker b=brokerRepository.findById(id).get();
		brokerRepository.deleteById(id);
		return b;
	}
	@Override
	public boolean checkBroker(long id) {
		if(brokerRepository.exsistsById(id))
			return true;
		return false;
		
	}

	
	
}
