package com.project.e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.e_commerce.model.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
