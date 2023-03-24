package com.bankproject.bankmgtsys.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Request Method Not Supported");
		details.add("Try again!!");
		ApiError errors = new ApiError(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);	
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Media Type Not Supported");
		details.add("Try again!!");
		ApiError errors = new ApiError(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);	
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Path Variable cannot be found");
		details.add("Try again!!");
		ApiError errors = new ApiError(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);	
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Type Mismatch");
		details.add("Try again!!");
		ApiError errors = new ApiError(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);	
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Wrong parameter");
		details.add("Try again!!");
		ApiError errors = new ApiError(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);	
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Message not readable");
		details.add("Try again!!");
		ApiError errors = new ApiError(message,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);	
	}
	
	//Handles all Account not found exceptions
		@ExceptionHandler(AccountNumberNotFoundException.class)
		protected ResponseEntity<Object> handleAccountNumberNotFoundException(AccountNumberNotFoundException ex){
			String message = ex.getMessage();
			List<String> details = new ArrayList<>();
			details.add("Account Number not found");
			details.add("Try again!!");
			ApiError errors = new ApiError(message,details,HttpStatus.NOT_FOUND,LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
		}
		
		//Error handling all other errors apart from the one we wrote
				@ExceptionHandler(Exception.class)
				protected ResponseEntity<Object> handleException(Exception ex){
					String message = ex.getMessage();
					List<String> details = new ArrayList<>();
					details.add("Account Number Not found at all");
					details.add("Try again!!");
					ApiError errors = new ApiError(message,details,HttpStatus.NOT_FOUND,LocalDateTime.now());
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
		
}
}
