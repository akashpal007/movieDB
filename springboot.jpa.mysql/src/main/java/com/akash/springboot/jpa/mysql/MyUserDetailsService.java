package com.akash.springboot.jpa.mysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akash.springboot.jpa.mysql.dao.UserDao;
import com.akash.springboot.jpa.mysql.vo.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<User> user = userDao.findByName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Id -" + userName));

		return new MyUserDetails(user.get());
	}

}
