package com.gmail.fomenkoc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gmail.fomenkoc.dao.UserRepository;
import com.gmail.fomenkoc.domain.User;
import com.gmail.fomenkoc.domain.UserRole;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		logger.info("Create new user {}: " + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}

	public User findByEmail(String email) {
		logger.info("Get user by email: " + email);
		return userRepository.findByEmail(email).get();
	}
	
	public void deleteUserByEmail(String email) {
		User user = findByEmail(email);
		logger.info("Delete user by email: " + email);
		userRepository.delete(user);
	}

}
