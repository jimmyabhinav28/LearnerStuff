package dev.abhinav.restapis.utils;

public class RestClientException extends Exception {

	public RestClientException(String message) {
		super(message);
	}

	public RestClientException(String message, Exception e) {
		super(message, e);
	}

}
