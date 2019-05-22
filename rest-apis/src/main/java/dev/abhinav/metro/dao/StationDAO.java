package dev.abhinav.metro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.metro.entities.Station;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class StationDAO {

	@Autowired
	StationRepository stationRepository;

	public Station findByStationName(String stationName) throws StationNotFoundException {
		List<Station> stations = null;
		try {
			stations = stationRepository.findByStationName(stationName);
			if (stations == null || stations.isEmpty())
			{
				log.info("station name " + stationName + " not found");
				return null;
			}
		} catch (Exception e) {
			String msg="Station is null!";
			throw new StationNotFoundException(msg,e);
		}
		return stations.get(0);
	}
	
	 public void deleteById(Long id) { 
		 stationRepository.deleteById(id);
	 }
	
	/*
	 * public void deleteByName(String name) { stationRepository.deleteByName(name);
	 * }
	 * 
	 * public void deleteUsingQuery(String name) {
	 * stationRepository.deleteUsingQuery(name); }
	 */
}