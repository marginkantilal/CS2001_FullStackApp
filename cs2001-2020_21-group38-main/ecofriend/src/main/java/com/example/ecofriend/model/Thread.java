package com.example.Ecofriend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Thread")

public class Thread 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int thread_id;
	
	@Column(name="thread_title", nullable=false, unique=false, length=100)
	private String thread_title;
	
	public Thread() 
	{
		super();
	}
	
	public Thread(String thread_title, int thread_id) 
	{
		this.thread_title = thread_title;
		this.thread_id = thread_id;
	}
	
	//get and set
	
	public String getTitle() 
	{
		return thread_title;
	}
	
	public int getID() 
	{
		return thread_id;
	}
	
	public void setTitle(String thread_title) 
	{
		this.thread_title=thread_title;
	}
	
	public void setID(int thread_id) 
	{
		this.thread_id = thread_id;
	}
	
}
