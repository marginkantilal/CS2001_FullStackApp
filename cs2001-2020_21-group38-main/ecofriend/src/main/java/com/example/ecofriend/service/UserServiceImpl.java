package com.example.ecofriend.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecofriend.exception.ResourceNotFoundException;
import com.example.ecofriend.model.Role;
import com.example.ecofriend.model.User;
import com.example.ecofriend.repository.UserRepository;

import com.example.ecofriend.web.dto.UserRegistrationDto;

@Service()
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;




	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getAccount(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}


	//Reset password feature
	public void updateResetPasswordToken(String token, String email) throws ResourceNotFoundException {
		User user = userRepository.findByEmail(email);


		if(user != null) {//check if the user doesn't exist
			user.setResetPasswordToken(token);
			userRepository.save(user);
		}
		else {
			throw new ResourceNotFoundException("User not found with this: " + email);
		}

	}

	//identify the user with the token sent 
	public User getResetPasswordToken(String token) {
		return userRepository.findByResetPasswordToken(token);
	}

	//set new password for the user 
	public void updatePassword(User user, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(newPassword);
		
		user.setPassword(encodePassword);//set new password
		user.setResetPasswordToken(null);
		
		userRepository.save(user);
	}


}
