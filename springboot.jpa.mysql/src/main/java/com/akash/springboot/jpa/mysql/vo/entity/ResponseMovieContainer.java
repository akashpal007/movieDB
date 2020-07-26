package com.akash.springboot.jpa.mysql.vo.entity;

import com.akash.springboot.jpa.mysql.vo.dto.MovieDto;

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
