package dev.abhinav.metro.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.dto.RouteDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDtlsResponse {
	
	@JsonProperty("data")
	RouteDTO data;
}
