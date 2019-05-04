package dev.abhinav.metro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.metro.entities.Station;


public interface StationRepository extends JpaRepository<Station, Long>{

	List<Station> findByStationName(String specialName);
	
}
