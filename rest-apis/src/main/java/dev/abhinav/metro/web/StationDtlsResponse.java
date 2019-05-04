package dev.abhinav.metro.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.dto.StationDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationDtlsResponse {
	
	@JsonProperty("data")
	StationDTO data;
}
