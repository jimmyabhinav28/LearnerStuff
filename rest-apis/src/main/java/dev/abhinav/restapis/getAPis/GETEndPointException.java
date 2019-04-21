package dev.abhinav.restapis.getAPis;

public class GETEndPointException extends Exception {

	public GETEndPointException(String message) {
		super(message);
	}

	public GETEndPointException(String message, Exception e) {
		super(message, e);
	}

}
