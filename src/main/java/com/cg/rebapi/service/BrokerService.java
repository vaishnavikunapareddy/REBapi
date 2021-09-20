package com.cg.rebapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.repository.BrokerRepository;
@Service
public interface BrokerService {
	
	public Broker addBroker(Broker broker);
	public List<Broker> listOfBrokers();
	public Broker deleteBroker(long id) throws BrokerException;
	public boolean checkBroker(long id);
	public Broker getBroker(long id) throws BrokerException;

}
