package com.business.customermanagement.controllers;

import java.util.UUID;

import javax.validation.Valid;

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

	private AddressService addressService;
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	/**
	 * Update the customer's address.
	 *
	 * @param id - id of the existing customer
	 * @param AddressDto address information
	 * @return updated customer with its id
	 */
	@PutMapping
	public CustomerDto updateAddress(@PathVariable(name = "id") @ApiParam(value = "customerId", example = "6ace0d48-43ee-459c-ad80-6c1efd077ebb") UUID customer_id,@Valid @RequestBody AddressDto address) {
		return addressService.updateAddress(customer_id, address);
	}
}
