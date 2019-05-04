package dev.abhinav.metro.dao;

public class StationNotFoundException extends Exception {

	public StationNotFoundException(String message) {
		super(message);
	}

	public StationNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
