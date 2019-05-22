package dev.abhinav.metro.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "station_engineer")
public class StationEngineer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "metro_employee_id", nullable = false)
	Long metroEmployeeId;

	@Column(name = "engineer_name")
	String engineerName;

	@Column(name = "station_assignment_start_date")
	Date assignmentStartDate;
	
	@OneToOne(mappedBy = "stationEngineer", fetch = FetchType.EAGER)
	Station station;

}
