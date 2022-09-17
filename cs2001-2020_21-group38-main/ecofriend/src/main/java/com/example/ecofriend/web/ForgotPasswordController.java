
package com.example.ecofriend.web;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecofriend.exception.ResourceNotFoundException;
import com.example.ecofriend.model.User;
import com.example.ecofriend.service.UserServiceImpl;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private JavaMailSender mailSender;

	// Display the forgot password form
	@RequestMapping(value="/forgotpassword", method=RequestMethod.GET)
	public ModelAndView displayForgotPassword(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("forgotpassword");
		return modelAndView;
	}


	@RequestMapping(value="/forgotpassword", method=RequestMethod.POST)
	public String proccessForgetpasssRequest(HttpServletRequest request, Model model) throws UnsupportedEncodingException   {
		String email = request.getParameter("email");
		String token = RandomString.make(30); //length of the token to reset password

		try {
			
			userServiceImpl.updateResetPasswordToken(token, email);

			//Generate reset password link based on the token
			String resetPasswordLink = Utility.getSiteURL(request) + "http://localhost:8080/resetpassword?token=" + token;
			
			//Send email 
			sendEmail(email, resetPasswordLink);
			model.addAttribute("message", "The reset password link has been sent to your email.");


			}
		//show an error if email not found 
		catch (ResourceNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
		} 
		catch (UnsupportedEncodingException | MessagingException ex) {
			model.addAttribute("error" + "There was error while sending an email");
		}

		return "forgotpassword";

	}


	//Sends the link to reset password 
	private void sendEmail(String email, String resetPasswordLink) throws MessagingException, UnsupportedEncodingException {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg); //customing own email 

		//from our email the link will be sent  

		helper.setFrom("ecofriend38@gmail.com", "Eco Friend");
		helper.setTo(email);


		//email body
		String subject = "Here's your click to reset your password";
		String emailContent = "<p>Hi there,</p>" 
				+ "<p>You have requested to reset your password.</p>" 
				+ "<p>click the below link to change your password:</p>"
				+ "<br>"
				+ "<p><a href=\"" + resetPasswordLink + "\">Change my password</a></p>"

		+ "<h6>Please ignore this email, if you didn't request to change your password</h6>";

		helper.setSubject(subject);
		helper.setText(emailContent, true);

		mailSender.send(msg);

	}


	//to show reset password page 
	@RequestMapping(value="/resetpassword", method=RequestMethod.GET)
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
		User user = userServiceImpl.getResetPasswordToken(token);

		if (user == null) {
			model.addAttribute("error", "The link is Invalid," + " "
					+ "Please request for new link to continue");
			return "error";
		}

		model.addAttribute("token", token);
		model.addAttribute("title", "Reset Your Password");

		return "resetpassword";

	}
	//to handle reset password form
	@RequestMapping(value="/resetpassword", method=RequestMethod.POST)
	public String  processResetPassword(HttpServletRequest httpRequest, 
			 Model model) {
		String token = httpRequest.getParameter("token");
		String password = httpRequest.getParameter("password");

		User user = userServiceImpl.getResetPasswordToken(token); 

		if (user == null) {
			model.addAttribute("error","The link already has been used, "
					+ "to continue request for new one"); //error message and its text
			return "error"; //shows error message
		} 
		else 
		{     	    	
			userServiceImpl.updatePassword(user, password);
			model.addAttribute("message", "Password successfully has been reset. You can now log in with the new credentials.");      

		}

		return "message"; //shows sucess message

	}
}