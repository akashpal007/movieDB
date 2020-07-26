package com.akash.springboot.jpa.mysql.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
	private Integer id;
	private String title;
	private Double vote_average;
	private String overview;
	private Double myRating;
}
