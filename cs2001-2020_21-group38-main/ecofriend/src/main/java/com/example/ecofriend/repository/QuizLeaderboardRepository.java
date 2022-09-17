package com.example.ecofriend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecofriend.model.QuizLeaderboard;

@Repository 
public interface QuizLeaderboardRepository extends 
JpaRepository<QuizLeaderboard, Long> {


	
}
