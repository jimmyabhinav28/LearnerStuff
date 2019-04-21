package dev.abhinav.restapis.getAPis;

public class DownStreamAPICallException extends Exception {

	public DownStreamAPICallException(String message) {
		super(message);
	}

	public DownStreamAPICallException(String message, Exception e) {
		super(message, e);
	}

}
