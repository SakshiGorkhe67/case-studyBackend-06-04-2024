package com.product.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.product.payloads.ApiResponse;

public class GlobalExceptionHandler {

	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
    	log.error(ex.getMessage());
    	String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		
    	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
       }

}
