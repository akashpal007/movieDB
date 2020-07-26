package com.akash.springboot.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMovieContainer {

	private Integer page;
	private Integer total_results;
	private Integer total_pages;
	private MovieDto[] results;
}
