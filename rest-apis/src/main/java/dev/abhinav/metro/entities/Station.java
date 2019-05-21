package dev.abhinav.metro.entities;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "station")
@Getter
@Setter
public class Station {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "station_name")
	String stationName;
	
	@Column(name = "start_date")
	Date start_date;

	//each station has a station incharge
	//though weird in real world, in our world, if the station is gone, the station incharge is gone
	//we will read up more on cascade types later
	//also notice the fetch attribute..It has two permissible values EAGER and LAZY
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="station_incharge_id", referencedColumnName = "id")
	StationIncharge stationIncharge;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="station_engineer_id", referencedColumnName = "id")
	StationEngineer stationEngineer;

}
