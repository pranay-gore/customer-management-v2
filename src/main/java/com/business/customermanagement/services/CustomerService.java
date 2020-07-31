package com.business.customermanagement.services;

import java.util.List;
import java.util.Optional;

import com.business.customermanagement.dtos.CustomerDto;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {
	
	/**
	 * Adds customer.
	 *
	 * @param customerDto - object representing customer
	 * @return the added customer with id
	 */
	CustomerDto addCustomer(CustomerDto customerDto);

	/**
	 * Updates customer.
	 *
	 * @param id - id of the customer
	 * @param customerDto - object representing customer
	 * @return the updated customer
	 */
	CustomerDto updateCustomer(Integer id, CustomerDto customerDto);

	/**
	 * Gets all customers.
	 *
	 * @return the all customers
	 */
	List<CustomerDto> getAllCustomers();

	/**
	 * Gets customer by id.
	 *
	 * @param id - id of the customer
	 * @return the customer
	 */
	CustomerDto getCustomerById(Integer id);

	/**
	 * Gets the list of customers
	 *
	 * @param firstName - first name of the customer
	 * @param lastName - last name of the customer
	 * @return the list
	 */
	List<CustomerDto> getByCustomerName(Optional<String> firstName, Optional<String> lastName);

}