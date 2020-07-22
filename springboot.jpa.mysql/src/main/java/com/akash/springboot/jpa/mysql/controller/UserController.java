package com.akash.springboot.jpa.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.springboot.jpa.mysql.dao.UserDao;
import com.akash.springboot.jpa.mysql.entity.User;
/**
 * @author Akash
 *
 */

@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/user")
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable long id) {
		return userDao.findById(id);
	}

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userDao.save(user);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userDao.save(user);
	}

}
