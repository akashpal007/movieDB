package com.akash.springboot.jpa.mysql.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.springboot.jpa.mysql.vo.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);

}
