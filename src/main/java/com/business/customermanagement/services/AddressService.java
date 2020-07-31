package com.business.customermanagement.services;

import com.business.customermanagement.dtos.AddressDto;
import com.business.customermanagement.dtos.CustomerDto;

public interface AddressService {

	/**
	 * Updates customer's address.
	 *
	 * @param id - id of the customer
	 * @param customerDto - object representing customer
	 * @return the updated customer
	 */
	CustomerDto updateAddress(Integer id, AddressDto addressDto);
}
