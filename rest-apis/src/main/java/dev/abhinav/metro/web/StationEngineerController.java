package dev.abhinav.metro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.metro.service.StationService;

@RestController
@RequestMapping("/stationEngineer")
public class StationEngineerController {
	
	
	
		@Autowired
		StationService stationService;

	/*
	 * @DeleteMapping(path = "/{station_engineer_name}") public void
	 * deleteByName(@PathVariable(name = "station_engineer_name") String
	 * stationEngineerName){ stationService.deleteByName(stationEngineerName); }
	 * 
	 * @DeleteMapping(path = "/deleteQuery/{station_engineer_name}") public void
	 * deleteUsingQuery(@PathVariable(name = "station_engineer_name") String
	 * stationEngineerName){ stationService.deleteUsingQuery(stationEngineerName); }
	 */
	}


