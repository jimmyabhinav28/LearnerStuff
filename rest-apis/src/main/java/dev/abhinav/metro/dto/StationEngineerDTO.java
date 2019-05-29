package dev.abhinav.metro.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.entities.StationEngineer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class StationEngineerDTO {

	@JsonProperty("id")
	Long id;

	@NotNull
	@JsonProperty("metro_employee_id")
	Long metroEmployeeId;
	
	@NotBlank
	@JsonProperty("engineer_name")
	String engineerName;

	@JsonProperty("station_assignment_start_date")
	Date assignmentStartDate;
	
	@JsonBackReference
	@JsonProperty("station_engineer")
	StationDTO station;

	public StationEngineerDTO(StationEngineer stationEngineer) throws Exception {
		this.id = stationEngineer.getId();
		this.metroEmployeeId = stationEngineer.getMetroEmployeeId();
		this.engineerName = stationEngineer.getEngineerName();
		this.assignmentStartDate = new Date(stationEngineer.getAssignmentStartDate().getTime());
//		this.station=new StationDTO(stationEngineer.getStation());
	}
}
