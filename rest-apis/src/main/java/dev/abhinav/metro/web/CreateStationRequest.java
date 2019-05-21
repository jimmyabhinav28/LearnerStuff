package dev.abhinav.metro.web;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.dto.StationEngineerDTO;
import dev.abhinav.metro.dto.StationInchargeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStationRequest {

	@NotBlank
	@JsonProperty("station_name")
	String stationName;
	
	@JsonProperty("station_incharge")
	StationInchargeDTO stationIncharge;
	
	@JsonProperty("station_engineer")
	StationEngineerDTO stationEngineer;
}
