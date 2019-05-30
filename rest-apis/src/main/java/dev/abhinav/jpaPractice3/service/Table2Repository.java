package dev.abhinav.jpaPractice3.service;

import dev.abhinav.jpaPractice3.entities.Table2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface Table2Repository extends JpaRepository<Table2Entity, Long> {
	@Override
	@Transactional
	@Query("delete from Table2Entity e where e.table3.id=?1")
	void deleteById(Long id);
}
