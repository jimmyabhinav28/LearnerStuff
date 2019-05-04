package dev.abhinav.metro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.abhinav.metro.entities.Route;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RouteDAO {
	@Autowired
	RouteRepository routeRepository;

	public Route findByRouteDestination(String destName) throws RouteNotFoundException {
		List<Route> routes = null;
		try {
			routes = routeRepository.findByRouteDestination(destName);
			if (routes == null || routes.isEmpty())
			{
				log.info("route with destination " + destName + " not found");
				return null;
			}
		} catch (Exception e) {
			String msg="Route is null!";
			throw new RouteNotFoundException(msg,e);
		}
		return routes.get(0);
	}
}
