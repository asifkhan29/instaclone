package com.instaclone.vo;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ErrorDetailVO {
	
	private String errorCode;
	private String erorMessgae;
	private String result;
	private String requestUri;
	private HttpStatus httpStatus;
	
}
