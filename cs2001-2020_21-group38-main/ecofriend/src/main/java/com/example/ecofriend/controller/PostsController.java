package com.example.Ecofriend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecofriend.model.Posts;
import com.example.Ecofriend.repository.PostsRepo;
import com.example.Ecofriend.service.PostsService;

@RestController
@RequestMapping(path = "/posts")
public class PostsController {
	
	private final PostsService postService;
	
	@Autowired
	public PostsController(PostsService postService) 
	{
		this.postService = postService;
	}
	
	@GetMapping("/id")
	public List<Posts> getPosts()
	{
		return postService.getAllPosts();
	}
	
	@PostMapping("/add")
	public void addPost(@RequestBody Posts post_name) 
	{
		postService.addNewPost(post_name);
	}
}
