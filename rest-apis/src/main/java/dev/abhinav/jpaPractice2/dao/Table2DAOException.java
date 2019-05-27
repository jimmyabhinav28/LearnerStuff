package dev.abhinav.jpaPractice2.dao;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Table2DAOException extends Exception {
	public Table2DAOException(String message,Exception e)
	{
		super(message,e);
	}

	public Table2DAOException(String message)
	{
		super(message);
	}
}
