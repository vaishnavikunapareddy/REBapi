package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.exception.PlotException;
import com.cg.rebapi.model.Plot;



public interface PlotService {

	public List<Plot> listOfPlots();

	public Plot deletePlot(long id) throws PlotException;

	public Plot addPlot(Plot plot);

	public boolean checkPlot(long id);

	public Plot getPlot(long id) throws PlotException;

	
    
}
