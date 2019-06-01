package dev.abhinav.jpaPractice4.service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Table1ServiceException extends Exception {

	public Table1ServiceException(String message) {
		super(message);
	}

	public Table1ServiceException(String message, Exception e) {
		super(message, e);
	}
}
