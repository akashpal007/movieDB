package com.akash.springboot.jpa.mysql.entity;

import java.io.Serializable;

public class UserMovieRatingsPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1271609949196573132L;

	private Integer userId;
	private Integer movieId;
	
	public UserMovieRatingsPk() {
		
	}
	/**
	 * @param userId
	 * @param movieId
	 */
	public UserMovieRatingsPk(Integer userId, Integer movieId) {
		super();
		this.userId = userId;
		this.movieId = movieId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the movieId
	 */
	public Integer getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMovieRatingsPk other = (UserMovieRatingsPk) obj;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}
