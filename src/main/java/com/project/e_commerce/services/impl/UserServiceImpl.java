package com.project.e_commerce.services.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.e_commerce.model.Role;
import com.project.e_commerce.model.User;
import com.project.e_commerce.repositories.RoleRepository;
import com.project.e_commerce.repositories.UserRepository;
import com.project.e_commerce.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findOneByEmail(String email) {
		return userRepository.findByEmail(email);
	}	
	
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(2);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}
}
