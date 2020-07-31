package com.business.customermanagement.dtos;

import com.business.customermanagement.entities.Address;

import lombok.Data;

/**
 * Represents a customer dto.
 */
@Data
public class CustomerDto {

	private Integer id;

	private String firstName;
	
	private String lastName;

	private int age;
	
	private Address currentAddress;
}
