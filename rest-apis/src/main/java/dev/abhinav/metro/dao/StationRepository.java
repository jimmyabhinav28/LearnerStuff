package dev.abhinav.metro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import dev.abhinav.metro.entities.Station;


public interface StationRepository extends JpaRepository<Station, Long>{

	List<Station> findByStationName(String specialName);
	
	@Transactional
	@Modifying
	void deleteByName(String name);
	
	@Transactional
	@Modifying
	@Query("delete from station where station_name = ?")
	void deleteUsingQuery(String name);
	
}
