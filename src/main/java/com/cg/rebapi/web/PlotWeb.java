package com.cg.rebapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rebapi.serviceimpl.PlotServiceImpl;

@RestController
@RequestMapping("/plots")
public class PlotWeb {
	
	@Autowired
	public PlotServiceImpl plotService;
	
	

}
