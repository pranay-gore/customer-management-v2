package com.business.customermanagement.dtos;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.business.customermanagement.entities.Address;

import lombok.Data;

/**
 * Represents a customer dto.
 */
@Data
public class CustomerDto {

	private UUID customerId;

	@NotBlank(message = "Firstname is mandatory")
	private String firstName;
	@NotBlank(message = "Lastname is mandatory")
	private String lastName;
	@Positive(message = "Age should be greater than 0")
	private int age;
	@NotNull(message = "Address is mandatory")
	@Valid
	private Address currentAddress;
}
