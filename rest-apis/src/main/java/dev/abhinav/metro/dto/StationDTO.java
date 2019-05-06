package dev.abhinav.metro.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import dev.abhinav.metro.entities.Station;
import dev.abhinav.metro.entities.Train;
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

	@JsonProperty("station_incharge_name")
	String stationInchargeName;

	public StationDTO(Station station) throws Exception {
		if(station!=null)
		{
			this.stationId = station.getId();
			this.stationName = station.getStationName();
			this.startDate = station.getStart_date();
			this.stationInchargeName=station.getStationIncharge().getInchargeName();
		}
		else
			throw new Exception("station has null value");
	}
}
