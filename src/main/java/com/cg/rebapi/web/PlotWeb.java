package com.cg.rebapi.web;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.MethodArgumentsNotValidException;
import com.cg.rebapi.exception.PlotException;
import com.cg.rebapi.model.Address;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
import com.cg.rebapi.serviceimpl.AddressServiceImpl;
import com.cg.rebapi.serviceimpl.PlotServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("api/plots")
public class PlotWeb {
	@Autowired
	public PlotServiceImpl plotServiceImpl;
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getPlots(){
		List<Plot> plotList= plotServiceImpl.listOfPlots();
		if(plotList==null)
			return new ResponseEntity<>(plotList,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(plotList,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addShop(@Valid @RequestBody Plot plot, BindingResult bindingResult) throws MethodArgumentsNotValidException{
//		if(bindingResult.hasErrors()) {
//			throw new MethodArgumentsNotValidException();
//		}
//		else if(plot.getPlotAddress()==null)
//			return new ResponseEntity<String>("plot should have address, please provide address" , HttpStatus.NOT_ACCEPTABLE);
//		
//		if(addressServiceImpl.checkAddress(plot.getPlotAddress().getId())) {
		Address address=addressServiceImpl.addAddress(plot.getPlotAddress());
				Plot plotSaved=plotServiceImpl.addPlot(plot);
				return new ResponseEntity<Plot>(plotSaved, HttpStatus.CREATED);
//		}
//		return new ResponseEntity<String>("plot cannot be added, Address id"+plot.getPlotAddress().getId()+ " not found" , HttpStatus.NOT_ACCEPTABLE);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getPlot(@PathVariable("id") long id) throws PlotException{
		Plot plot= plotServiceImpl.getPlot(id);
		if(plot==null)
			return new ResponseEntity<>(plot,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(plot,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePlot(@PathVariable("id") long bno) throws PlotException{
		Plot plotSaved=plotServiceImpl.deletePlot(bno);
		if(plotSaved==null)
			return new ResponseEntity<>(plotSaved,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(plotSaved,HttpStatus.OK);
	}
	
	@GetMapping("getstatus/{status}")
	public ResponseEntity<?> getPlotStatus(@PathVariable("status") String status){
		List<Plot> plotList= plotServiceImpl.getPlotStatus(status);
		if(plotList==null)
			return new ResponseEntity<>(plotList,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(plotList,HttpStatus.OK);
	}
	
	

}