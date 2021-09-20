package com.cg.rebapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rebapi.model.Plot;
import com.cg.rebapi.repository.PlotRepository;
import com.cg.rebapi.service.PlotService;


@Service
public class PlotServiceImpl implements PlotService {
	
	
		@Autowired
		PlotRepository plotDao;
		@Override
		public List<Plot> listOfPlots(){
			List<Plot> plots=plotDao.findAll();
			return plots;
			
		}
		@Override
		public Plot addPlot(Plot plot) {
			Plot p=  plotDao.save(plot);
			return p;
		}
		@Override
		public Plot updatePlot(Plot plot) {
			return  plotDao.save(plot);
		}
		@Override
		public Plot deletePlot(int id) {
			Plot p= plotDao.findById(id).get();
			plotDao.deleteById(id);
			return p;
		}
		
		public boolean checkPlot(int id) {
			if(plotDao.existsById(id))
				return true;
			return false;
			
		}

		
		
}