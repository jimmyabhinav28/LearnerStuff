package dev.abhinav.metro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abhinav.metro.dao.StationDAO;
import dev.abhinav.metro.dto.StationDTO;

@Service
public class StationService {
	
	@Autowired
	StationDAO stationDAO;
	
	public StationDTO findByStationName(String stationName) throws Exception
	{
		return new StationDTO(stationDAO.findByStationName(stationName));
	}
	
	public void deleteByName(String name) {
		stationDAO.deleteByName(name);
		
	}
	public void deleteUsingQuery(String name) {
		stationDAO.deleteUsingQuery(name);
		
	}
	
}
