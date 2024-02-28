package com.instaclone.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.instaclone.constant.ConstantFields;
import com.instaclone.vo.ErrorDetailVO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Object> handler(UserException userException , HttpServletRequest httpServletRequest)
	{
		ErrorDetailVO edv = new ErrorDetailVO();
		edv.setErorMessgae(userException.getErrorMessage());
		edv.setErrorCode(userException.getErrorCode());
		edv.setHttpStatus(userException.getHttpStatus());
		edv.setRequestUri(httpServletRequest.getRequestURI());
		edv.setResult(ConstantFields.RESULT);
		return ResponseEntity.accepted().body(edv);
	}
	
}
