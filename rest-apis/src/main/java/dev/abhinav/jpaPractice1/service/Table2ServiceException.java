package dev.abhinav.jpaPractice1.service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Table2ServiceException extends Exception {

	public Table2ServiceException(String message, Exception e) {
		super(message, e);
	}

	public Table2ServiceException(String message) {
		super(message);
	}
}
