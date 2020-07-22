package com.akash.springboot.jpa.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.springboot.jpa.mysql.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
