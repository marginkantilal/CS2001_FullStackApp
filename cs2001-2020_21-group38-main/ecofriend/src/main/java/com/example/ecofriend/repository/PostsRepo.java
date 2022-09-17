
package com.example.Ecofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Ecofriend.model.Posts;


@Repository 
public interface PostsRepo extends 
JpaRepository<Posts, Long>  
{
	
} 