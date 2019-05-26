package dev.abhinav.jpaPractice2.service;

import dev.abhinav.jpaPractice2.dao.Table3DAOException;

public class Table3ServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Table3ServiceException(String message) {
		super(message);
	}

	public Table3ServiceException(String message, Table3DAOException e) {
		super(message, e);
	}

}
