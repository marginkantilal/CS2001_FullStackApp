package com.example.ecofriend.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.ecofriend.model.User;

import com.example.ecofriend.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
