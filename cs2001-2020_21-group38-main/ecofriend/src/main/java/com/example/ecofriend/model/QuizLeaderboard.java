package com.example.ecofriend.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "quiz")
public class QuizLeaderboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "Res_Id",nullable = false, unique = true, length = 10)
	private Long id;

	@Column(name = "Username", nullable = false, unique = false, length = 50)
	private String username;
	@Column(name = "Score", nullable = false, unique = false, length = 100)
	private int score;
	


	public QuizLeaderboard() {
	}

	public QuizLeaderboard(String username, int score) {
		super();
		this.username = username;
		this.score = score;
	}

	
	public Long getId() {
		return id;
	}

	public void setIdset(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}





}