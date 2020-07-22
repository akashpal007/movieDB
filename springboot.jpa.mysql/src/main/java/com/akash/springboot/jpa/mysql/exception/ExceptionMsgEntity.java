package com.akash.springboot.jpa.mysql.exception;

import java.util.Date;
/**
 * @author Akash
 *
 */

public class ExceptionMsgEntity {
	private String message;
	private String details;
	private Date timestamp;

	/**
	 * @param message
	 * @param details
	 * 
	 */
	public ExceptionMsgEntity(String message, String details) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = new Date();
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
