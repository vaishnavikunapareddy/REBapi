package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.exception.EmptyFieldException;
import com.cg.rebapi.exception.EmptyListException;
import com.cg.rebapi.exception.PlotException;
import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;
import com.cg.rebapi.repository.AddressRepository;
import com.cg.rebapi.repository.PlotRepository;
import com.cg.rebapi.service.PlotService;


@Service
public class PlotServiceImpl implements PlotService{
	
	@Autowired
	PlotRepository plotRepository;
	@Autowired
	AddressRepository addressRepository;
	@Override
	public List<Plot> listOfPlots(){
		List<Plot> plots=plotRepository.findAll();
		if(plots.isEmpty())
			throw new EmptyListException();
		return plots;
		
	}
	@Override
	public Plot addPlot(Plot plot) {
		if(plot.getPlotName().isEmpty()||plot.getPlotName().length()==0)
			throw new EmptyFieldException("601", "Input feilds are empty");
		Plot p= plotRepository.save(plot);
		return p;
	}
	

	@Override
	public Plot deletePlot(long id) throws PlotException  {
		if(plotRepository.existsById(id)) {
		Plot p=plotRepository.findById(id).get();
		addressRepository.deleteById(p.getPlotAddress().getId());
		plotRepository.deleteById(id);
		return p;
		}
		throw new PlotException("Plot with id "+id + " is not there to delete");
	}
	@Override
	public boolean checkPlot(long id) {
		if(plotRepository.existsById(id))
			return true;
		return false;
		
	}

	@Override
	public Plot getPlot(long id) throws PlotException{
		
		if(plotRepository.existsById(id)) {
			Plot p=plotRepository.findById(id).get();
			return p;
		}
		//throw new PlotException("Plot with id "+id+" is not there to get");
		return null;
	}
	
	@Override
	public List<Plot> getPlotStatus(String status){
		List<Plot> plotList=plotRepository.getPlotStatus(status);
		if(plotList.isEmpty())
			//throw new EmptyListException();
			return null;
		return plotList;
		
	}
	

		
		
}