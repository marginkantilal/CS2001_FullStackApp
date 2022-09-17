package com.example.ecofriend.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionHandling   {
	
	private final String message;
	private  final HttpStatus httpStatus;
	private final ZonedDateTime timeStamp;
	
	public ExceptionHandling(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

	
	

}
