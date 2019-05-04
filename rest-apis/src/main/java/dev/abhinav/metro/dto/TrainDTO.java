package dev.abhinav.metro.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.abhinav.metro.entities.Train;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDTO {

	@JsonProperty("train_id")
	private Long id;

	@JsonProperty("special_name")
	private String specialName;

	@JsonProperty("service_start_date")
	private Date serviceStartDate;

	@JsonProperty("last_maintainance_date")
	private Date lastMaintainanceDate;

	@JsonProperty("vendor")
	private String vendorName;

	public TrainDTO(Train train) throws Exception {
		if(train!=null)
		{
			this.id = train.getId();
			this.lastMaintainanceDate = train.getLastMaintainanceDate();
			this.serviceStartDate = train.getServiceBeginDate();
			this.vendorName = train.getVendorName();
			this.specialName=train.getSpecialName();
		}
		else
			throw new Exception("train parameter is null");
	}
}
