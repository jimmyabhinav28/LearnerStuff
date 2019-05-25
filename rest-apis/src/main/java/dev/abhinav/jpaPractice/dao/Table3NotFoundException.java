package dev.abhinav.jpaPractice.dao;

public class Table3NotFoundException extends Exception{
	
	public Table3NotFoundException(String message) {
		super(message);
	}

	public Table3NotFoundException(String message, Exception e) {
		super(message, e);
	}

}
