package com.akash.springboot.jpa.mysql.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.springboot.jpa.mysql.entity.UserMovieRatings;
import com.akash.springboot.jpa.mysql.entity.UserMovieRatingsPk;

public interface UserMovieRatingsDao extends JpaRepository<UserMovieRatings, UserMovieRatingsPk> {

	UserMovieRatings findByUserIdAndMovieId(Integer userId, Integer id);

	List<UserMovieRatings> findByUserIdOrderByTimestampDesc(Integer userId, Pageable pageable);

}
