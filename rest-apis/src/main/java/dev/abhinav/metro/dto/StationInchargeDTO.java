package dev.abhinav.metro.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.entities.StationIncharge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class StationInchargeDTO {

	@JsonProperty("id")
	Long id;

	@NotNull
	@JsonProperty("metro_employee_id")
	Long metroEmployeeId;

	@NotBlank
	@JsonProperty("incharge_name")
	String inchargeName;

	@JsonProperty("station_assignment_start_date")
	Date assignmentStartDate;

	public StationInchargeDTO(StationIncharge stationIncharge) {
		this.id = stationIncharge.getId();
		this.metroEmployeeId = stationIncharge.getMetroEmployeeId();
		this.inchargeName = stationIncharge.getInchargeName();
		this.assignmentStartDate = new Date(stationIncharge.getAssignmentStartDate().getTime());
	}
}
