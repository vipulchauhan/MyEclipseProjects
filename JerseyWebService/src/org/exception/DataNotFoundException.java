package org.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {

		super(message);
		System.out.println("DataNotFoundException");

	}

}
