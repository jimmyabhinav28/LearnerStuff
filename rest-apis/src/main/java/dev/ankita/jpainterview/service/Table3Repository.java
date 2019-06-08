package dev.ankita.jpainterview.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ankita.jpainterview.entities.Table1;
import dev.ankita.jpainterview.entities.Table3;

public interface Table3Repository  extends JpaRepository<Table1,Long>{
	
	List<Table3> findByAttribute1(String attribute1Value);
}
