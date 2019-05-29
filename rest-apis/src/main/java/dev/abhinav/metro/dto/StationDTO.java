package dev.abhinav.metro.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.abhinav.metro.entities.Station;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationDTO {

	@JsonProperty("station_id")
	private Long stationId;

	@JsonProperty("station_name")
	private String stationName;

	@JsonProperty("start_date")
	private Date startDate;

	@JsonProperty("station_incharge_details")
	StationInchargeDTO stationIncharge;

	@JsonManagedReference
	@JsonProperty("station_engineer_details")
	StationEngineerDTO stationEngineer;
	
	public StationDTO(Station station) throws Exception {
		if(station!=null)
		{
			this.stationId = station.getId();
			this.stationName = station.getStationName();
			this.startDate = station.getStart_date();
			this.stationIncharge=new StationInchargeDTO(station.getStationIncharge());
			this.stationEngineer=new StationEngineerDTO(station.getStationEngineer());
		}
		else
			throw new Exception("station has null value");
	}
}
