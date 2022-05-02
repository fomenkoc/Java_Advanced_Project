package com.gmail.fomenkoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gmail.fomenkoc.dao.UserRepository;
import com.gmail.fomenkoc.domain.User;
import com.gmail.fomenkoc.domain.UserRole;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }
    
    public User findByEmail(String email) {
    	return userRepository.findByEmail(email).get();
    }

}
