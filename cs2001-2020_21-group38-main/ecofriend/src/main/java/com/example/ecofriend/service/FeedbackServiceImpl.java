package com.example.ecofriend.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecofriend.exception.ResourceNotFoundException;
import com.example.ecofriend.model.Feedback;
import com.example.ecofriend.model.User;
import com.example.ecofriend.repository.FeedbackRepository;

import com.example.ecofriend.web.dto.FeedbackDto;

@Service()
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
	private FeedbackRepository feedbackRepository;
	public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
		super();
		this.feedbackRepository = feedbackRepository;
	}

	@Override
	public Feedback save(FeedbackDto feedbackDto) {
		Feedback feedback = new Feedback(feedbackDto.getFirstName(), 
				feedbackDto.getLastName(), feedbackDto.getEmail(),
				feedbackDto.getMessage());
		
		return feedbackRepository.save(feedback);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Feedback feedback = feedbackRepository.findByEmail(username);
		if(feedback == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return null;		
	}
}
