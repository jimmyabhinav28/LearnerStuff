package dev.abhinav.metro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.abhinav.metro.entities.Station;


public interface StationRepository extends JpaRepository<Station, Long>{

	List<Station> findByStationName(String specialName);
	
	@Transactional
	@Modifying
	@Query("delete from Station s where s.stationName=?1")
	public void deleteByStationName(String stationName);
	
	@Transactional
	@Modifying
//	@Cascade(CascadeType.ALL)
	@Query(value = "delete s,p from station s, station_engineer p where s.station_name=?1 and p.id=s.station_engineer_id;", nativeQuery = true)
	public void deleteStationAndStationEngineerByStationName(String stationName);
	
	
}
