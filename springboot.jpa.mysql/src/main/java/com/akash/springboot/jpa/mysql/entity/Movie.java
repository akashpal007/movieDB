package com.akash.springboot.jpa.mysql.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie {
	@Id
	private Integer id;
	private String title;
	private Double averageRating;
	@Lob
	private String overview;

	public Movie() {

	}

	/**
	 * @param id
	 * @param title
	 * @param averageRating
	 * @param overview
	 */
	public Movie(Integer id, String title, Double averageRating, String overview) {
		super();
		this.id = id;
		this.title = title;
		this.averageRating = averageRating;
		this.overview = overview;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the averageRating
	 */
	public Double getAverageRating() {
		return averageRating;
	}

	/**
	 * @param averageRating the averageRating to set
	 */
	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
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

}
