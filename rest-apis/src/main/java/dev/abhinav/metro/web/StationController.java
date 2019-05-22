package dev.abhinav.metro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.metro.service.StationService;


	@RestController
	@RequestMapping("/station")
	public class StationController {
		@Autowired
		StationService stationService;

		@GetMapping(path = "/{station_name}")
		public StationDtlsResponse findByStationName(@PathVariable(name = "station_name") String stationName)
				throws Exception {
			StationDtlsResponse response = new StationDtlsResponse();
			response.setData(stationService.findByStationName(stationName));
			return response;
		}
		
		@PostMapping(path = "/insertStation")
		public StationDtlsResponse saveStation(@PathVariable(name = "station_name") String stationName)
				throws Exception {
			StationDtlsResponse response = new StationDtlsResponse();
			//response.setData(stationService.saveStation(stationName));
			return response;
		}
		
	/*
	 * @DeleteMapping(path = "delete/{station_engineer_name}") public void
	 * deleteByName(@PathVariable(name = "station_engineer_name") String
	 * stationrName){ stationService.deleteByName(stationrName); }
	 * 
	 * @DeleteMapping(path = "/deleteQuery/{station_engineer_name}") public void
	 * deleteUsingQuery(@PathVariable(name = "station_engineer_name") String
	 * stationName){ stationService.deleteUsingQuery(stationName); }
	 */
	}

