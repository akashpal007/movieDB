package com.akash.springboot.jpa.mysql.vo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_MOVIE_RATINGS")
@IdClass(UserMovieRatingsPk.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
