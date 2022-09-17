package com.example.ecofriend.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecofriend.model.Donation;

@Repository 
public interface DonationRepository extends 
JpaRepository<Donation, Long> {

	List<Donation> findRestaurantById(Long restaurantId);

	@Transactional
	@Query("select r.name as Restaurant_Name, sum(d.quantity) as Total_Donation "
			+ "from Restaurant r left join Donation " 
			+ "d  on r.id = d.restaurant where d.quantity is not null" 
			+ " group by r.name order by Total_Donation desc")
	List<?> GetTotalDonationByRestaurant();
	
	
}

