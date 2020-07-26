package com.akash.springboot.jpa.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.springboot.jpa.mysql.vo.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer> {

//	List<Movie> findByUser_IdOrderByMyRatingDesc(Integer userId, Pageable pageable);
//
//	List<Movie> findByUser_IdOrderByTimestampDesc(Integer userId, Pageable pageable);
//
//	List<Movie> findByUser_IdOrderByTimestampDesc(Integer userId);
//
//	Movie findByUser_IdAndId(Integer userId, String id);

	Movie findAllById(Integer id);

}
