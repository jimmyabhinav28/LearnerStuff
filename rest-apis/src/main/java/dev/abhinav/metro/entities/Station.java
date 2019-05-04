package dev.abhinav.metro.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "station")
@Getter
@Setter
public class Station {
	
	@Id
	@Column(name = "station_id")
	Long stationId;
	
	@Column(name = "station_name")
	String stationName;
	
	@Column(name = "start_date")
	Date start_date;
	

}
