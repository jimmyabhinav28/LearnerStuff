package dev.abhinav.web;

import java.util.Date;
import java.util.UUID;

import org.slf4j.MDC;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@AllArgsConstructor
public class MetaData 
{
	@JsonProperty("request_id")
	String requestId;
	
	@JsonProperty("response_id")
	String responseId;
	
	@JsonProperty("response_send_time")
	Date responseSendTime;
	
	public MetaData() throws MetaDataCreateException
	{
		//picks request id from MDC
		//forms a response id and logs it against response id
//		requestId=MDC.get("X-B3-TraceId:-");
		requestId=UUID.randomUUID().toString();
		//log.info(MDC.getCopyOfContextMap().keySet().toString());
		if(requestId==null)
		{
			String message="no request id present in MDC";
			throw new MetaDataCreateException(message);
		}
		responseId=UUID.randomUUID().toString();
		log.debug("response id corresponding to request id "+requestId +" is "+responseId);
		responseSendTime=new Date();
	}
}
