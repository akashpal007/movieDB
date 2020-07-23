package com.akash.springboot.jpa.mysql.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MOVIE_RATINGS")
@IdClass(UserMovieRatingsPk.class)
public class UserMovieRatings {
	@Id
	@JoinColumn(name = "userId")
	private Integer userId;
	
	@Id
	@JoinColumn(name = "movieId")
	private Integer movieId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "movieId", insertable = false, updatable = false)
	private Movie movie;
	
	
	private Double rating;

	@Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date timestamp;

	public UserMovieRatings() {

	}

	/**
	 * @param userId
	 * @param movieId
	 * @param user
	 * @param movie
	 * @param rating
	 * @param timestamp
	 */
	public UserMovieRatings(Integer userId, Integer movieId, User user, Movie movie, Double rating,
			Date timestamp) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.user = user;
		this.movie = movie;
		this.rating = rating;
		this.timestamp = timestamp;
	}



	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
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

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
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
