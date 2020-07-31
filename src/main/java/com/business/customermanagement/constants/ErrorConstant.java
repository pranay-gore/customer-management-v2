package com.business.customermanagement.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum ErrorConstant - declares error codes and respective messages
 */
@Getter
@AllArgsConstructor
public enum ErrorConstant {

	CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "Customer with given id does not exist"),
	CUSTOMERS_NOT_FOUND("CUSTOMERS_NOT_FOUND", "Customers do not exist"),
	SERVER_ERROR("INTERNAL_SERVER_ERROR", "Something went wrong. Please try again later"),
	BAD_REQUEST("BAD_REQUEST", "Please enter all required fields");

	private final String errorCode;
	private final String errorMessage;

}
