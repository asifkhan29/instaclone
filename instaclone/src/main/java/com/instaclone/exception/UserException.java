package com.instaclone.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	private HttpStatus httpStatus;

}
