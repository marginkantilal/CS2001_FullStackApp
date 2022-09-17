package com.example.ecofriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecofriend.model.UserProfile;
import com.example.ecofriend.repository.OrganizationRepository;
import com.example.ecofriend.repository.RestaurantRepository;
import com.example.ecofriend.service.EcoUserDetailsService;


@RestController
@RequestMapping("/api/Organization")
public class OrganizationController 
{
	@Autowired
	OrganizationRepository OrganizationRepository;
	
	
}
	
