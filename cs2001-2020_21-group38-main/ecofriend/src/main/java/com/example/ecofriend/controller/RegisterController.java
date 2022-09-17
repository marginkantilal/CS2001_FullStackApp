package com.example.ecofriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecofriend.model.UserProfile;
import com.example.ecofriend.service.EcoUserDetailsService;

@RestController
public class RegisterController {
	
	@Autowired
	private EcoUserDetailsService userDetailsService;
	
	//Create
	//@CrossOrigin("http://localhost:3000")
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public ResponseEntity<?> addUser(@RequestBody UserProfile user) {
		userDetailsService.addUser(user);
		return ResponseEntity.ok("yes"); // sends a http code 200 to the frontend
	}
}
