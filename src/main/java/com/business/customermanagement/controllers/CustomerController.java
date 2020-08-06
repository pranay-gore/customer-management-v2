package com.business.customermanagement.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.services.CustomerService;

import io.swagger.annotations.ApiParam;

/**
 * The Class CustomerController - Rest Controller where services are exposed 
 * to perform operations on customer resource
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Adds the customer
	 * 
	 * @param customerDto the customer who needs to be added
	 * @return customer with its newly generated id
	 */
	@PostMapping
	public CustomerDto addCustomer(@Valid @RequestBody CustomerDto customer) {
		return customerService.addCustomer(customer);
	}
	
	/**
	 * Update the customer.
	 *
	 * @param id - id of the existing customer
	 * @param customerDto the customer with updated information
	 * @return updated customer with its id
	 */
	@PutMapping("/{id}")
	public CustomerDto updateCustomer(@PathVariable @ApiParam(value = "customerId", example = "6ace0d48-43ee-459c-ad80-6c1efd077ebb") UUID id,@Valid @RequestBody CustomerDto customer) {
		return customerService.updateCustomer(id, customer);
	}
	
	/**
	 * Gets the customer by id
	 *
	 * @param id - id of the customer
	 * @return the customer from the database if it exists
	 */
	@GetMapping("/{id}")
	public CustomerDto getCustomerById(@PathVariable @ApiParam(value = "customerId", example = "6ace0d48-43ee-459c-ad80-6c1efd077ebb") UUID id) {
		return customerService.getCustomerById(id);
	}
	
	/**
	 * Gets the customers
	 *
	 * @param firstName - the first name of the customer
	 * @param lastName - the last name of the customer
	 * @return the list of customers matching with given criteria if any exists
	 */
	@GetMapping
	public List<CustomerDto> getCustomers(@RequestParam(name = "fname") @ApiParam(value = "firstname") Optional<String> firstName,@RequestParam(name = "lname") @ApiParam(value = "lastname") Optional<String> lastName) {
		if(!firstName.isPresent() && !lastName.isPresent()) {
			return customerService.getAllCustomers();
		} else {
			return customerService.getByCustomerName(firstName, lastName);
		}
	}
}
