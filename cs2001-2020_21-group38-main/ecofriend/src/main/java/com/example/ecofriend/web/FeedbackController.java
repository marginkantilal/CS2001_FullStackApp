package com.example.ecofriend.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecofriend.service.FeedbackService;

import com.example.ecofriend.web.dto.FeedbackDto;

@Controller
@RequestMapping("/contact")
public class FeedbackController {

	private FeedbackService feedbackService;

	public FeedbackController(FeedbackService feedbackService) {
		super();
		this.feedbackService = feedbackService;
	}
	
	@ModelAttribute("feedback")
    public FeedbackDto feedbackDto() {
        return new FeedbackDto();
    }
	
	@GetMapping
	public String showFeedbackForm() {
		return "feedback";
	}
	
	@PostMapping
	public String dummyregisterFeedbackAccount(@ModelAttribute("feedback") FeedbackDto feedbackDto) {
		feedbackService.save(feedbackDto);
		return "redirect:/contact?success";
	}
}
