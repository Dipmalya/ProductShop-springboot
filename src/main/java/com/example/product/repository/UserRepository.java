package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.model.User;

public interface UserRepository extends JpaRepository<User, String> {

		public User findByUserEmail(String userEmail);
}
