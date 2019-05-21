package dev.abhinav.metro.service;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.abhinav.metro.dao.StationDAO;
import dev.abhinav.metro.dao.StationNotFoundException;
import dev.abhinav.metro.dto.StationDTO;
import dev.abhinav.metro.entities.Station;
import dev.abhinav.metro.entities.StationEngineer;
import dev.abhinav.metro.entities.StationIncharge;
import dev.abhinav.metro.web.CreateStationRequest;

@Service
public class StationService {

	@Autowired
	StationDAO stationDAO;

	public StationDTO findByStationName(String stationName) throws Exception {
		return new StationDTO(stationDAO.findByStationName(stationName));
	}

	public StationDTO save(CreateStationRequest createStationRequest) throws Exception {
		Station station = new Station();
		station.setStationName(createStationRequest.getStationName());
		station.setStart_date(new Date(new java.util.Date().getTime()));

		if (createStationRequest.getStationIncharge() != null) {
			StationIncharge stationIncharge = new StationIncharge();
			stationIncharge.setInchargeName(createStationRequest.getStationIncharge().getInchargeName());
			stationIncharge.setMetroEmployeeId(createStationRequest.getStationIncharge().getMetroEmployeeId());
			stationIncharge.setAssignmentStartDate(new Date(new java.util.Date().getTime()));
			station.setStationIncharge(stationIncharge);
		}
		if (createStationRequest.getStationEngineer() != null) {
			StationEngineer stationEngineer = new StationEngineer();
			stationEngineer.setMetroEmployeeId(createStationRequest.getStationEngineer().getMetroEmployeeId());
			stationEngineer.setEngineerName(createStationRequest.getStationEngineer().getEngineerName());
			stationEngineer.setAssignmentStartDate(new Date(new java.util.Date().getTime()));
			station.setStationEngineer(stationEngineer);
		}

		station = stationDAO.save(station);
		return new StationDTO(station);
	}

	public void delete(StationDTO station) {
		stationDAO.deleteById(station.getStationId());
		
	}
	
	
}
