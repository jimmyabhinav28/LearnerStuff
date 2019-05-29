package dev.abhinav.metro.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.metro.dto.StationDTO;
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

	@PostMapping(path = "/addNewStation")
	public StationDTO addStation(@Valid @RequestBody CreateStationRequest createStationRequest) throws Exception {
		StationDTO savedStationDetails = null;
		savedStationDetails = stationService.save(createStationRequest);
		return savedStationDetails;

	}

	/*
	 * @DeleteMapping("/deleteStation/{station_name}") public StationDTO
	 * deleteStation(@PathVariable(name = "station_name") String stationName) throws
	 * Exception { StationDTO station=stationService.findByStationName(stationName);
	 * stationService.delete(station.getStationId()); return station; }
	 */

	@DeleteMapping("/deleteStation/{stationId}")
	public void deleteStation(@PathVariable(name = "stationId") Long stationId) throws Exception {
//		StationDTO station = stationService.findByStationName(stationName);
		stationService.delete(stationId);
//		return station;
	}
	
	@DeleteMapping("/deleteStation2/{station_name}")
	public void deleteStation2(@PathVariable(name = "station_name") String stationName) throws Exception {
//		StationDTO station = stationService.findByStationName(stationName);
		stationService.deleteByStationName(stationName);
//		return station;
	}

}
