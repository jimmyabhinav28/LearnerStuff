package dev.abhinav.metro.dao;

public class RouteNotFoundException extends Exception {

	public RouteNotFoundException(String message) {
		super(message);
	}

	public RouteNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
