package dev.abhinav.metro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import dev.abhinav.metro.entities.StationEngineer;

public interface StationEngineerRepository extends JpaRepository<StationEngineer, Long>{
	
	/*
	 * @Transactional
	 * 
	 * @Modifying void deleteByName(String name);
	 */
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query("delete from station_engineer where engineer_name = ?1") void
	 * deleteUsingQuery(String name);
	 */
}
