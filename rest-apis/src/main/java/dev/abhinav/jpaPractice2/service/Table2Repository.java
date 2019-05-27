package dev.abhinav.jpaPractice2.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.abhinav.jpaPractice2.entities.Table2Entity;

public interface Table2Repository extends JpaRepository<Table2Entity, Long> {
	@Transactional
	@Query("delete from Table2Entity e where e.table3.id=?1")
	void deleteById(Long id);
}