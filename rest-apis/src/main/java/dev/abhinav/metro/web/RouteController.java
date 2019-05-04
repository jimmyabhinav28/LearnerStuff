package dev.abhinav.metro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.metro.service.RouteService;



	@RestController
	@RequestMapping("/route")
	public class RouteController {
		@Autowired
		RouteService routeService;

		@GetMapping(path = "/{des_name}")
		public RouteDtlsResponse findByRouteDestination(@PathVariable(name = "des_name") String destName)
				throws Exception {
			RouteDtlsResponse response = new RouteDtlsResponse();
			response.setData(routeService.findByRouteDestination(destName));
			return response;
		}
	}

