package com.example.ecofriend.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<Object> handleDonationRequestException(ResourceNotFoundException error){
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ExceptionHandling  donationException =
				new ExceptionHandling (error.getMessage(),
						badRequest,
						ZonedDateTime.now(ZoneId.of("Z"))
		);
		
		return new ResponseEntity<>(donationException, badRequest);
	}
}


