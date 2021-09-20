package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.BrokerException;
import com.cg.rebapi.model.Broker;
import com.cg.rebapi.serviceimpl.BrokerServiceImpl;

@RestController
@RequestMapping("/brokers")
public class BrokerWeb {
	@Autowired
	public BrokerServiceImpl brokerService;
	
	@GetMapping("/getbrokers")
	public ResponseEntity<Object> getBrokers(){
		List<Broker> brokerList= brokerService.listOfBrokers();
		return new ResponseEntity<>(brokerList, HttpStatus.OK);
	}
	
	@PostMapping("/addbroker")
	public @ResponseBody String addEmployee(@RequestBody Broker broker) {
		if(brokerService.checkBroker(broker.getId())) {
			brokerService.addBroker(broker);
		return "Broker with "+broker.getId()+" got updated";
		}
		brokerService.addBroker(broker);
		return "broker got added successfully";
	}
	
	@DeleteMapping("/deletebroker/{id}")
	public @ResponseBody String deleteBroker(@PathVariable("id") int bno) throws BrokerException{
		if(brokerService.checkBroker(bno)) {
			brokerService.deleteBroker(bno);
			return "Broker got deleted ";
		}
		throw new BrokerException("broker with id "+bno+" was not present to delete");
	}
	
	
	

}
