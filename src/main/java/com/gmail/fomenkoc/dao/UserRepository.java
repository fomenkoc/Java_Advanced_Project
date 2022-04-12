package com.gmail.fomenkoc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.fomenkoc.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByEmail(String email);
}
