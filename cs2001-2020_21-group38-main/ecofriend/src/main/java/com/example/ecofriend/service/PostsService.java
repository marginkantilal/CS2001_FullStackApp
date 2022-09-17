package com.example.Ecofriend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Ecofriend.model.Posts;
import com.example.Ecofriend.repository.PostsRepo;

public class PostsService {
	
	private final PostsRepo postRepo;
	
	@Autowired
	public PostsService(PostsRepo postRepo) 
	{
		this.postRepo = postRepo;
	}
	
	public List<Posts> getAllPosts()
	{
		return postRepo.findAll();
	}

	public void addNewPost(Posts post_name) {
		System.out.println(post_name);
	}
	
 

}
