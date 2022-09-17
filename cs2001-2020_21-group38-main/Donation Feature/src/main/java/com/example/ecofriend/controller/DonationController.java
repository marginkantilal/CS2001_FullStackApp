package com.example.ecofriend.controller;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ecofriend.exception.ResourceNotFoundException;
import com.example.ecofriend.model.Donation;
import com.example.ecofriend.model.Restaurant;
import com.example.ecofriend.repository.DonationRepository;
import com.example.ecofriend.repository.RestaurantRepository;

@RestController
public class DonationController {


	@Autowired
	DonationRepository donationRepository;
	@Autowired
	RestaurantRepository resRepo;

	//getting all donations list by restaurants
	@CrossOrigin
	@GetMapping("/restaurants/donations")
	public ResponseEntity<?>getDonations() throws ResourceNotFoundException {
		List<Donation> donation = donationRepository.findAll();
		
		if(donation.isEmpty() || donation ==null) {
			throw new ResourceNotFoundException("Sorry, there is no record found in the system"); //shows an error if no such as record is existed in the database
		}else 
		{
			return new ResponseEntity<>(donation, HttpStatus.OK);
		}
	}
	//getting all donations list by restaurant id
	@CrossOrigin
	@GetMapping("/restaurants/{restaurantId}/donations")
	public ResponseEntity<?> getDonationsByRestaurant(@PathVariable(value = "restaurantId") Long restaurantId) throws ResourceNotFoundException {
		List<Donation> existedId=  donationRepository.findByRestaurantId(restaurantId);
		if(existedId.isEmpty()|| existedId==null) {
			throw new ResourceNotFoundException("the restaurant never has donated or the restaurant doesn't exist with: " + restaurantId); //shows an error restaurant is not existed by the id or restaurant never donated.
		}else 
		{
			return new ResponseEntity<>(existedId, HttpStatus.OK); //if found then it shows status as OK
		}
	}
	//Adding donation list by restaurant id
	@CrossOrigin
	@PostMapping("/add/donations/{restaurantId}")
	public Donation addDonationByRestaurantId(@PathVariable() Long restaurantId, Restaurant res,
			@Valid @RequestBody Donation donation) throws ResourceNotFoundException {
		return resRepo.findById(restaurantId).map(restaurant ->{
			donation.setRestaurant(restaurant);
			return donationRepository.save(donation);
		}).orElseThrow(() -> new ResourceNotFoundException("Restaurant does't on exist with " + restaurantId + 
				"  Create Restaurant Record In The System and Donate Later")); //error occurs if the restaurant is not existed in the system with that id
	}
	
	//Getting Restaurant Name And its total donation
	@CrossOrigin
	@GetMapping("/mostdonation")
	public ResponseEntity<?>getTotalDonationByRestaurant() throws ResourceNotFoundException {
		 List<?> mostDonation = donationRepository.GetTotalDonationByRestaurant();

		if(mostDonation.isEmpty()|| mostDonation==null) {
			throw new ResourceNotFoundException("Record doesn't exist in the system"); //shows an error restaurant is not existed by the id or restaurant never donated.
		}else 
		{
			return new ResponseEntity<>(mostDonation, HttpStatus.OK); //if found then it shows status as OK
		}
	}
	//Get Restaurant Details By Restaurant Name
	@CrossOrigin
	@GetMapping("/restaurant/{name}")
    public ResponseEntity <?> getRestaurantByName(
        @PathVariable(value = "name") String name) throws ResourceNotFoundException {
		Restaurant restaurant = resRepo.findRestaurantByName(name);
		if(restaurant== null) 
		{
			throw new ResourceNotFoundException("the restaurant doesn't exist with name: " + name); //shows an error if the restaurant doesn't exist by this name
		}
		else 
		{
			return new ResponseEntity<>(restaurant, HttpStatus.OK);
		}

    }
	
}
