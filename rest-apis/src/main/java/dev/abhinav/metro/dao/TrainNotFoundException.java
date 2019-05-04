package dev.abhinav.metro.dao;

public class TrainNotFoundException extends Exception {

	public TrainNotFoundException(String message) {
		super(message);
	}

	public TrainNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
