package com.example.Ecofriend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="Replies")

public class Replies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long replyId;
	
	@Column(name="msgCount", nullable=false, unique=false, length=100)
	
	private long msgCount;
	
	public Replies() 
	{
		super();
	}
	
	public Replies(long replyId, long msgCount) 
	{
		this.replyId = replyId;
		this.msgCount = msgCount;
	}
	
	//get and set
	
	public long getID() 
	{
		return replyId;
	}
	
	public long getmsgCount() 
	{
		return msgCount;
	}

}
