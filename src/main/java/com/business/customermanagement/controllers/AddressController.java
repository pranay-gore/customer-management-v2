package com.business.customermanagement.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.customermanagement.dtos.AddressDto;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.services.AddressService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/customers/{id}/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * Update the customer's address.
	 *
	 * @param id - id of the existing customer
	 * @param AddressDto address information
	 * @return updated customer with its id
	 */
	@PutMapping
	public CustomerDto updateAddress(@PathVariable(name = "id") @ApiParam(value = "customerId", example = "1") Integer customer_id,@Valid @RequestBody AddressDto address) {
		return addressService.updateAddress(customer_id, address);
	}
}
