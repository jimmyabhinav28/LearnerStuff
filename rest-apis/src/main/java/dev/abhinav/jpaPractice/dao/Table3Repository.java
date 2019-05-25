package dev.abhinav.jpaPractice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.jpaPractice.entities.Table3;
import dev.abhinav.metro.entities.Station;

public interface Table3Repository extends JpaRepository<Table3, Long> {
	
	List<Table3> findByAttribute1(String attributeName);
	void deleteById(Long id);
	Table3 save(Table3 table3);

}
