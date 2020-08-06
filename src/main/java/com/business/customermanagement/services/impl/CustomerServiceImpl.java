package com.business.customermanagement.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.converters.CustomerConverter;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;
import com.business.customermanagement.repositories.CustomerRepository;
import com.business.customermanagement.services.CustomerService;

/**
 * The Class CustomerServiceImpl - includes all business logic
 * required to perform operations on customer resource
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepo;

	private CustomerConverter customerConverter;
	
	public CustomerServiceImpl(CustomerRepository customerRepo, CustomerConverter customerConverter) {
		this.customerRepo = customerRepo;
		this.customerConverter = customerConverter;
	}

	/**
	 * Adds customer.
	 *
	 * @param customerDto - object representing customer
	 * @return the added customer with id
	 */
	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customer customer = customerConverter.dtoToEntity(customerDto);
		return customerConverter.entityToDto(customerRepo.save(customer));
	}

	/**
	 * Updates customer.
	 *
	 * @param id - id of the customer
	 * @param customerDto - object representing customer
	 * @return the updated customer
	 */
	@Override
	public CustomerDto updateCustomer(UUID id, CustomerDto customerDto) {
		Customer savedCustomer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(ErrorConstant.CUSTOMER_NOT_FOUND));
		savedCustomer.setFirstName(customerDto.getFirstName());
		savedCustomer.setLastName(customerDto.getLastName());
		savedCustomer.setAddress(customerDto.getCurrentAddress());
		savedCustomer.setAge(customerDto.getAge());
		return customerConverter.entityToDto(customerRepo.save(savedCustomer));
	}

	/**
	 * Gets all customers.
	 *
	 * @return the all customers
	 */
	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
			return customerConverter.entityToDto(customers);
	}

	/**
	 * Gets customer by id.
	 *
	 * @param id - id of the customer
	 * @return the customer
	 */
	@Override
	public CustomerDto getCustomerById(UUID id) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(ErrorConstant.CUSTOMER_NOT_FOUND));
		
		return customerConverter.entityToDto(customer);
	}

	/**
	 * Gets the list of customers
	 * 
	 * @param firstName - first name of the customer
	 * @param lastName - last name of the customer
	 * @return the list
	 */
	@Override
	public List<CustomerDto> getByCustomerName(Optional<String> firstName, Optional<String> lastName) {
		List<Customer> customers = null;
		if (firstName.isPresent() && lastName.isPresent()) {
			customers = customerRepo.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName.get(), lastName.get());
		} else if (firstName.isPresent()) {
			customers = customerRepo.findByFirstNameIgnoreCase(firstName.get());
		} else if (lastName.isPresent()){
			customers = customerRepo.findByLastNameIgnoreCase(lastName.get());
		} 
		
		if (customers.isEmpty()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMERS_NOT_FOUND);
		}

		return customerConverter.entityToDto(customers);
	}

}
