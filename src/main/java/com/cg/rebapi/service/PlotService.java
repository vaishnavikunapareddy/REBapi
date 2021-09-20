package com.cg.rebapi.service;

import java.util.List;

import com.cg.rebapi.model.Plot;



public interface PlotService {

	public List<Plot> listOfPlots();

	public Plot deletePlot(int id);

	public Plot addPlot(Plot plot);

	public Plot updatePlot(Plot plot);
    
}
