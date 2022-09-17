package com.example.ecofriend.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.ecofriend.model.Feedback;

import com.example.ecofriend.web.dto.FeedbackDto;

public interface FeedbackService extends UserDetailsService{
	Feedback save(FeedbackDto feedbackDto);
}
