package com.example.logger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.logger.entity.User;
import com.example.logger.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		
		return repo.save(user);
		
	}
	
	public User fecthUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fecthUserByEmailIdAndPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email,password);
	}

	
	
	

}
