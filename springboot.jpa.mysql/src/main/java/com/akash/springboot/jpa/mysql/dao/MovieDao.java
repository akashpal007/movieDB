package com.akash.springboot.jpa.mysql.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.springboot.jpa.mysql.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {

	List<Movie> findByUser_IdOrderByMyRatingDesc(long userId, Pageable pageable);

	List<Movie> findByUser_IdOrderByTimestampDesc(long userId, Pageable pageable);

	List<Movie> findByUser_IdOrderByTimestampDesc(long userId);

	Movie findByUser_IdAndId(long userId, String id);

}
