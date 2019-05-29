package dev.abhinav.metro.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.entities.Route;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDTO {

	@JsonProperty("route_id")
	private Long routeId;

	@JsonProperty("route_to")
	private String routeStartingPoint;

	@JsonProperty("route_from")
	private String routeDestination;
	
	@JsonProperty("start_date")
	private Date startDate;
	
	@JsonProperty("end_date")
	private Date endDate;


	public RouteDTO(Route route) throws Exception {
		if(route!=null)
		{
			this.routeId = route.getRouteId();
			this.routeStartingPoint = route.getRouteStartingPoint();
			this.routeDestination = route.getRouteDestination();
			this.startDate = route.getStartDate();
			this.endDate = route.getEndDate();
		}
		else
			throw new Exception("There are existing routes!!");
	}
}
