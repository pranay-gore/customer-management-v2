package com.business.customermanagement.services;

import java.util.UUID;

import com.business.customermanagement.dtos.AddressDto;
import com.business.customermanagement.dtos.CustomerDto;

public interface AddressService {

	/**
	 * Updates customer's address.
	 *
	 * @param customer_id - id of the customer
	 * @param customerDto - object representing customer
	 * @return the updated customer
	 */
	CustomerDto updateAddress(UUID customer_id, AddressDto addressDto);
}
