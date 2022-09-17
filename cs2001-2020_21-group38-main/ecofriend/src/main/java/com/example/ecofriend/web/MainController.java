package com.example.ecofriend.web;

import java.security.Principal;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecofriend.repository.UserRepository;
import com.example.ecofriend.web.dto.UserRegistrationDto;


@Controller
public class MainController {
	@Autowired
	private UserRepository userrepository;
	@RequestMapping(value = { "/logged"})
	public String logged() {
		return "logged";
	}

	@GetMapping("/index")
	public String home() {
		return "index";
	}
	@GetMapping("/donate")
	public String donate() {
		return "donate";
	}
	@GetMapping("/foodwaste")
	public String foodwaste() {
		return "foodwaste";
	}
	@GetMapping("/foodinfo")
	public String foodinfo() {
		return "foodinfo";
	}
	@GetMapping("/foodlist")
	public String foodlist() {
		return "foodlist";
	}
	@GetMapping("/Energy1")
	public String Energy1() {
		return "Energy1";
	}
	@GetMapping("/Energy2")
	public String Energy2() {
		return "Energy2";
	}
	@GetMapping("/Water")
	public String Water() {
		return "Water";
	}
	@GetMapping("/leaderboard")
	public String leaderboard() {
		return "leaderboard";
	}
	@GetMapping("/IndividualProfile")
	public String IndividualProfile() {
		return "IndividualProfile";
	}
	@GetMapping("/user profile")
	public String userProfile() {
		return "user profile";
	}
	@GetMapping("/quizPage")
	public String quizPage() {
		return "quizPage";
	}
	@GetMapping("/deleted")
	public String deleted() {
		return "deleted";
	}
	@GetMapping("/forum")
	public String forum() {
		return "forum";
	}
	
    @GetMapping("/login")
    public String showLoginForm(Model model) {
         
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
 
        return "redirect:/logged";
    }
	
	
 @RequestMapping("/delete")
 public String delete(Principal principal) {
	 String email = principal.getName();
	 long userid = userrepository.findByEmail(email).getId();
	 userrepository.deleteById(userid);
	 return "redirect:/deleted?AccountDeleted";
 }
	
	
}
