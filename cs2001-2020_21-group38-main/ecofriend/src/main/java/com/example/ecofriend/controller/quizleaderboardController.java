package com.example.ecofriend.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.ecofriend.model.QuizLeaderboard;
import com.example.ecofriend.repository.QuizLeaderboardRepository;

@RestController
@RequestMapping("/quizleaderboard")
public class quizleaderboardController {


	@Autowired
	QuizLeaderboardRepository quizleaderboardRepository;

	@PostMapping("/quiz")
	public QuizLeaderboard createLeaderboardEntry(@Valid @RequestBody QuizLeaderboard username, QuizLeaderboard score) {
		return quizleaderboardRepository.save(username);
	}

	//get all record from database
	//	@GetMapping("/all")
	//	public List<quizleaderboard>getAllDonation() {
	//		throw new quizleaderboardRequestException("Sorry record not found");
	//		//return donationRepository.findAll();
	//	}


	//	//get donation by id
	//	@GetMapping("/{id}")
	//	public quizleaderboard getquizleaderboardById(@PathVariable("id") Long id) {
	//		Optional <quizleaderboard> donation = quizleaderboardRepository.findById(id);
	//		return quizleaderboard.get();
	//	}
	//	
	//	//Add donation
	//	@PostMapping("/add")
	//	public quizleaderboard addquizleaderboard(@RequestBody quizleaderboard donation) {
	//		return donationRepository.save(donation);
	//	}
	//
	//	//Update record
	//	@PutMapping("/update")
	//	public Donation updateDonation(@RequestBody Donation donation) {
	//		return donationRepository.save(donation);
	//	}


}