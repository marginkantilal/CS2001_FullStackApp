package com.example.Ecofriend.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Posts")

public class Posts 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long post_id;
	
	@Column(name="post_name", nullable=false, unique=false, length=100)
	
	private String post_name;
	
	public Posts() 
	{
		super();
	}
	
	public Posts(String post_name, long post_id) 
	{
		this.post_name=post_name;
		this.post_id = post_id;
	}
	
	//get and set
	
	public String getName()  
	{
		return post_name;
	}
	
	public long getID() 
	{
		return post_id;
	}
	
	public void setName(String post_name) 
	{
		this.post_name=post_name;
	}
	
	public void setID(long post_id) 
	{
		this.post_id = post_id;
	}
	
}
