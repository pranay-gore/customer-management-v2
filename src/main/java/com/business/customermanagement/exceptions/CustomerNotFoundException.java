package com.business.customermanagement.exceptions;

import com.business.customermanagement.constants.ErrorConstant;

import lombok.Getter;

/**
 * Represents an exception to be thrown when customer does not exist
 *
 */
@Getter
public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String exceptionCode;
	
	private String exceptionMessage;

	/**
	 * Instantiates a new CustomerNotFoundException.
	 *
	 * @param constant the constant
	 */
	public CustomerNotFoundException(ErrorConstant constant) {
		this.exceptionCode = constant.getErrorCode();
		this.exceptionMessage = constant.getErrorMessage();
	}

}
