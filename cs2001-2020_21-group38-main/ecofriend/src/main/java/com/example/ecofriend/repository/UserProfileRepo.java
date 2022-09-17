package com.example.ecofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecofriend.model.UserProfile;

@Repository 
public interface UserProfileRepo extends 
JpaRepository<UserProfile, Integer> {
}
