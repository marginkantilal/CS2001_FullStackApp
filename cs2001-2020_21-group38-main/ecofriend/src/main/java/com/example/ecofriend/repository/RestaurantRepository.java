package com.example.ecofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecofriend.model.Restaurant;


@Repository 
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
