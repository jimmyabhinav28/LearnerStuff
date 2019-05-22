package dev.abhinav.metro.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.entities.StationEngineer;

public class StationEngineerDTO {
	
	@JsonProperty("id")
	Long id;

	@JsonProperty("metro_employee_id")
	Long metroEmployeeId;

	@JsonProperty("engineer_name")
	String engineerName;

	@JsonProperty("station_assignment_start_date")
	Date assignmentStartDate;

	public StationEngineerDTO(StationEngineer stationEngineer) {
		this.id = stationEngineer.getId();
		this.metroEmployeeId = stationEngineer.getMetroEmployeeId();
		this.engineerName = stationEngineer.getEngineerName();
		this.assignmentStartDate = new Date(stationEngineer.getAssignmentStartDate().getTime());
	}
}
