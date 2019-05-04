package dev.abhinav.metro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abhinav.metro.dao.RouteDAO;
import dev.abhinav.metro.dto.RouteDTO;

@Service
public class RouteService {
	
	@Autowired
	RouteDAO routeDAO;
	
	public RouteDTO findByRouteDestination(String destName) throws Exception
	{
		return new RouteDTO(routeDAO.findByRouteDestination(destName));
	}
	

}
