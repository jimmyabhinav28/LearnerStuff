package dev.abhinav.metro.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.dto.TrainDTO;
import dev.abhinav.web.MetaData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDetailsResponse {

	@JsonProperty("meta")
	MetaData metaData;
	
	@JsonProperty("data")
	TrainDTO data;
}
