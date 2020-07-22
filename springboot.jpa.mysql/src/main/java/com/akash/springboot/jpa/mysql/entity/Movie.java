package com.akash.springboot.jpa.mysql.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * @author Akash
 *
 */
@Entity
@Table(name = "movies")
public class Movie {
	@Id
	private String id;
	private String title;
	@Lob
	private String overview;
	private String vote_average;
	private String myRating;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date timestamp = new Date();

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	public Movie() {

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the overview
	 */
	public String getOverview() {
		return overview;
	}

	/**
	 * @param overview the overview to set
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}

	/**
	 * @return the vote_average
	 */
	public String getVote_average() {
		return vote_average;
	}

	/**
	 * @param vote_average the vote_average to set
	 */
	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
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
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timestamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}

	/**
	 * @return the myRating
	 */
	public String getMyRating() {
		return myRating;
	}

	/**
	 * @param myRating the myRating to set
	 */
	public void setMyRating(String myRating) {
		this.myRating = myRating;
	}

}
