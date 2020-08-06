package com.business.customermanagement.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;

/**
 * The Class CustomerConverter - has methods to convert DTO to entity and vice versa
 */
@Component
public class CustomerConverter {
	
	/**
	 * Converts Entity to Dto.
	 *
	 * @param customer - customer fetched from database
	 * @return the customer - dto
	 */
	public CustomerDto entityToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setAge(customer.getAge());
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setCurrentAddress(customer.getAddress());
		
		return customerDto;
	}
	
	/**
	 * Converts list of entities to list of dtos.
	 *
	 * @param customers - list of customers fetched from database
	 * @return the list
	 */
	public List<CustomerDto> entityToDto(List<Customer> customers) {
		return customers.stream().map(customer -> entityToDto(customer)).collect(Collectors.toList());
	}
	
	/**
	 * Converts dto to entity.
	 *
	 * @param customerDto - customer to be converted to entity
	 * @return the customer - Entity
	 */
	public Customer dtoToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setAddress(customerDto.getCurrentAddress());
		customer.setAge(customerDto.getAge());
		return customer;
	}
	
	/**
	 * Converts list of dto to list of entities.
	 *
	 * @param customerDtos - list of customers to be converted to entities
	 * @return the list of entities
	 */
	public List<Customer> dtoToEntity(List<CustomerDto> customerDtos) {
		return customerDtos.stream().map(customerDto -> dtoToEntity(customerDto)).collect(Collectors.toList());
	}
}
