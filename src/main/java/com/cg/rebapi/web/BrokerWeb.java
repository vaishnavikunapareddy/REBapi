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
	public ResponseEntity<?> getBrokers(){
		List<Broker> brokerList= brokerService.listOfBrokers();
		return new ResponseEntity<>(brokerList,HttpStatus.OK);
	}
	
	@PostMapping("/addbroker")
	public ResponseEntity<Broker> addBroker(@RequestBody Broker broker) {
		Broker brokerSaved=brokerService.addBroker(broker);
		return new ResponseEntity<Broker>(brokerSaved, HttpStatus.CREATED);
	}
	@GetMapping("/brokerlist/{id}")
	public ResponseEntity<?> getBroker(@PathVariable("id") long id){
		List<Broker> brokerList= brokerService.listOfBrokers();
		return new ResponseEntity<>(brokerList,HttpStatus.OK);
		
	}
	@DeleteMapping("/deletebroker/{id}")
	public ResponseEntity<?> deleteBroker(@PathVariable("id") long bno) throws BrokerException{
		Broker brokerSaved=brokerService.deleteBroker(bno);
		return new ResponseEntity<>(brokerSaved,HttpStatus.OK);
	}
	
	
	

}
