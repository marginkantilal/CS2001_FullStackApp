package com.example.ecofriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecofriend.model.UserProfile;
import com.example.ecofriend.repository.UserProfileRepo;

@Service
public class EcoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	//adds a user to the database
	public void addUser(UserProfile user) {
		userProfileRepo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
