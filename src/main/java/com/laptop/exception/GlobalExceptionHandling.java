package com.laptop.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<Object> Idnotexphandling(IdNotFoundException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	
	@ExceptionHandler(NoSuchElementException.class)//predefined//
	public ResponseEntity<Object> K(NoSuchElementException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}
	 @ExceptionHandler(NullPointerException.class)//predefined//
	 public ResponseEntity<Object> v(NullPointerException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	 
//	 @ExceptionHandler(ArithemeticException.class)//predefined//
//	 public ResponseEntity<Object> x(ArithemeticException e){
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//	}
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> BrandExceptionHandling(BrandNotFoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}


