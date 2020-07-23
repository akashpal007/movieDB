package com.akash.springboot.jpa.mysql.entity;

public class MovieDto {
	private Integer id;
	private String title;
	private Double vote_average;
	private String overview;
	private Double myRating;

	public MovieDto() {

	}

	/**
	 * @param id
	 * @param title
	 * @param vote_average
	 * @param overview
	 * @param myRating
	 */
	public MovieDto(Integer id, String title, Double vote_average, String overview, Double myRating) {
		super();
		this.id = id;
		this.title = title;
		this.vote_average = vote_average;
		this.overview = overview;
		this.myRating = myRating;
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
	 * @return the vote_average
	 */
	public Double getVote_average() {
		return vote_average;
	}

	/**
	 * @param vote_average the vote_average to set
	 */
	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
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
	 * @return the myRating
	 */
	public Double getMyRating() {
		return myRating;
	}

	/**
	 * @param myRating the myRating to set
	 */
	public void setMyRating(Double myRating) {
		this.myRating = myRating;
	}

}
