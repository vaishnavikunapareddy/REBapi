package com.cg.rebapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.exception.PlotException;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.serviceimpl.PlotServiceImpl;

@RestController
@RequestMapping("/plots")
public class PlotWeb {
	
	@Autowired
	public PlotServiceImpl plotService;
	
	@GetMapping("/getplots")
	public ResponseEntity<?> getPlots(){
		List<Plot> plotList= plotService.listOfPlots();
		return new ResponseEntity<>(plotList,HttpStatus.OK);
	}
	
	@PostMapping("/addplot")
	public ResponseEntity<Plot> addPlot(@RequestBody Plot plot) {
		Plot plotSaved=plotService.addPlot(plot);
		return new ResponseEntity<Plot>(plotSaved, HttpStatus.CREATED);
	}
	@GetMapping("/getplot/{id}")
	public ResponseEntity<?> getPlot(@PathVariable("id") long id){
		List<Plot> plotList= plotService.listOfPlots();
		return new ResponseEntity<>(plotList,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteplot/{id}")
	public ResponseEntity<?> deletePlot(@PathVariable("id") long bno) throws PlotException{
		Plot plotSaved=plotService.deletePlot(bno);
		return new ResponseEntity<>(plotSaved,HttpStatus.OK);
	}
	
	

}