package dev.abhinav.metro.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "route")
@Getter
@Setter
public class Route {
	
	@Id
	@Column(name="route_id")
	Long routeId;
	
	@Column(name="route_to")
	String routeStartingPoint;
	
	@Column(name = "route_from")
	String routeDestination;
	
	@Column(name = "start_date")
	Date startDate;
	
	@Column(name = "end_date")
	Date endDate;

}
