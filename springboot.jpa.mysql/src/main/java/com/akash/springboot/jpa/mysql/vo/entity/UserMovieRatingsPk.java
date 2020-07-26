package com.akash.springboot.jpa.mysql.vo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserMovieRatingsPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1271609949196573132L;

	private Integer userId;
	private Integer movieId;
	
}
