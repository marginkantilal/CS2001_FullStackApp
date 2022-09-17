package com.example.ecofriend.controller;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecofriend.exception.ResourceNotFoundException;
import com.example.ecofriend.model.Restaurant;
import com.example.ecofriend.repository.RestaurantRepository;



@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;

	//get all restaurants and its donations
	@GetMapping()
	public ResponseEntity<?> getResDonations() throws ResourceNotFoundException {
		List<Restaurant> resList = restaurantRepository.findAll();
		if(resList.isEmpty() || resList ==null) {
			throw new ResourceNotFoundException("Sorry, there is no record found in the system");
		}else 
		{
			return new ResponseEntity<>(resList, HttpStatus.OK);
		}
	}

	//get restaurant by its id
	@GetMapping("/restaurant/{id}")
    public ResponseEntity <?> getRestaurantById(
        @PathVariable(value = "id") Long restaurantId) throws ResourceNotFoundException {
		Restaurant orangisation = restaurantRepository.findById(restaurantId)
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with Id: " + restaurantId));
        return ResponseEntity.ok().body(orangisation);
    }
	

	//Add restaurant
	@PostMapping("/add/restaurant")
	public ResponseEntity<?> addRestaurant(@RequestBody Restaurant res) {
		Restaurant orangisation = restaurantRepository.save(res);
		return new ResponseEntity<>(orangisation, HttpStatus.OK);

	}
	//Change Restaurant Details By Restaurant Id
	@PutMapping("/restaurant/{id}")
    public ResponseEntity <?> updatedOrganisation(
        @PathVariable(value = "id") Long restaurantId,
        @Valid @RequestBody Restaurant organisationDetails) throws ResourceNotFoundException {
		Restaurant organisation = restaurantRepository.findById(restaurantId)
            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with: " + restaurantId));
		organisation.setName(organisationDetails.getName());
		organisation.setAddress(organisationDetails.getAddress());
		organisation.setPhonenumber(organisationDetails.getPhonenumber());
        final Restaurant updatedOrganisation = restaurantRepository.save(organisation);
        return ResponseEntity.ok(updatedOrganisation);

	}
	

}


