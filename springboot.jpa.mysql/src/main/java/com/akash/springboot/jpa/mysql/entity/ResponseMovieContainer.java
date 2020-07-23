package com.akash.springboot.jpa.mysql.entity;

public class ResponseMovieContainer {

	private Integer page;
	private Integer total_results;
	private Integer total_pages;
	private MovieDto[] results;

	public ResponseMovieContainer() {
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the total_results
	 */
	public Integer getTotal_results() {
		return total_results;
	}

	/**
	 * @param total_results the total_results to set
	 */
	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}

	/**
	 * @return the total_pages
	 */
	public Integer getTotal_pages() {
		return total_pages;
	}

	/**
	 * @param total_pages the total_pages to set
	 */
	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	/**
	 * @return the results
	 */
	public MovieDto[] getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(MovieDto[] results) {
		this.results = results;
	}

}
