package com.akash.springboot.jpa.mysql.exception;
/**
 * @author Akash
 *
 */
public class MovieNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2501229274022220879L;

	/**
	 * @param message
	 */
	public MovieNotFoundException(String message) {
		super(message);
	}

}
