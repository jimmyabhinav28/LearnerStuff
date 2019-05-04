package dev.abhinav.metro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.metro.entities.Route;



public interface RouteRepository extends JpaRepository<Route, Long>{

	List<Route> findByRouteDestination(String destName);
	
}

