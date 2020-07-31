package com.business.customermanagement.exceptions;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.dtos.ErrorResponse;

/**
 * The Class CustomerExceptionHandler - handles all exceptions from the applications
 */
@ControllerAdvice
public class CustomerExceptionHandler {
	
	/**
	 * Handles CustomerNotFoundException.
	 *
	 * @param notFoundException - exception of type CustomerNotFoundException
	 * @return the response entity with error code and message
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException
		(CustomerNotFoundException notFoundException) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now() ,notFoundException.getExceptionCode(), notFoundException.getExceptionMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles validation exception.
	 *
	 * @param exception the exception
	 * @return the response entity with error code and message
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(
			ConstraintViolationException validateException) {
	    ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
	    		ErrorConstant.BAD_REQUEST.getErrorCode(), 
	    		validateException.getConstraintViolations().stream().findFirst().get().getMessage());
	    return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(
			MethodArgumentNotValidException validateException) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
	    		ErrorConstant.BAD_REQUEST.getErrorCode(), 
	    		validateException.getBindingResult().getFieldErrors().stream().findFirst().get().getDefaultMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
