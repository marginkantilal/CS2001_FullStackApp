package com.example.ecofriend;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.ecofriend.controller.DonationController;
import com.example.ecofriend.controller.RestaurantController;
import com.example.ecofriend.model.Donation;
import com.example.ecofriend.repository.DonationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(DonationRepository.class)
class DonationControllerTest  {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper om;
	@Autowired
	private DonationController donationController;
	
	
	@Autowired
	private DonationRepository donRepo;

	
	 @Test
	public void testListDonations() throws Exception {
			List<Donation> donation = new ArrayList<Donation>();
			donation.add(new Donation("Hello", 500));
			donation.add(new Donation("Hello", 500));
			donation.add(new Donation("Hello", 500));
			donation.add(new Donation("Hello", 500));
			Mockito.when(donRepo.findAll()).thenReturn(donation);
		 
	       String url = "/restaurants/donations";
	       mockMvc.perform(get(url)).andExpect(status().isOk());
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(donationController).isNotNull();
	}

//@Test
//void testAddRestaurant() {
//	//create restaurant
//	Restaurant newRes = new Restaurant();
//
//	List<Donation> listOfDonation= new ArrayList<Donation>();
//	Donation newD = new Donation("Donations", 020);
//	listOfDonation.add(newD);
//	newRes.setName("Testing with Unit");
//	newRes.setAddress("Wembley LONDON");
//	newRes.setPhonenumber("020040080080");
//	newRes.setDonationList(listOfDonation);
//
//
//	HttpEntity<?>  addedRes = resController.addRestaurant(newRes);
//	assertNotNull(newRes);
//	assertNotNull(newRes.getId());
//
//}




}
