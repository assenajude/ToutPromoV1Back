package com.ToutPromoV1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppExecption extends RuntimeException{

	public AppExecption(String message) {
		super(message);
	
	}

	public AppExecption(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	

}
