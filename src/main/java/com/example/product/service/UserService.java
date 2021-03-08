package com.example.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.product.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	public User loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		com.example.product.model.User user = userRepository.findByUserEmail(userEmail);
		return new User(user.getUserEmail(), user.getUserPwd(), new ArrayList<>());
	}
	
	public void registerUser(com.example.product.model.User user) {
		userRepository.save(user);
	}
}
