package com.sicredi.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sicredi.api.response.Response;

@ControllerAdvice
public class VotacaoExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = VotacaoRuntimeException.class)
	protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
		
		Response<String> response = new Response<>();
		response.getErrors().add(ex.getMessage());
		
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
